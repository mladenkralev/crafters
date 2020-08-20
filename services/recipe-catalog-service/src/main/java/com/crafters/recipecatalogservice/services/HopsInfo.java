package com.crafters.recipecatalogservice.services;

import com.crafters.recipecatalogservice.models.Hop;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HopsInfo {

    @Autowired
    public RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallbackHopItem",
            threadPoolKey = "recipeInfoPool",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "20"),
                    @HystrixProperty(name = "maxQueueSize", value = "10")
            },

            commandProperties = {
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000"),
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
                    @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "5000"),
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50")
            }
    )
    public Hop getHopItem(String hopItem) {
        Hop hopCollection =
                restTemplate.getForObject("http://HOPS-INFO-SERVICE/api/v1/hops/" + hopItem,
                        Hop.class);
        return hopCollection;
    }

    public Hop fallbackHopItem(String recipeId) {
        return new Hop("Default", "None");
    }
}
