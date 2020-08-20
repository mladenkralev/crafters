package com.crafters.recipecatalogservice.services;

import com.crafters.recipecatalogservice.models.Yeast;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class YeastInfo {

    @Autowired
    public RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallbackYeastItem",
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
    public Yeast getYeastItem(String yeastId) {
        Yeast yeastCollection =
                restTemplate.getForObject("http://YEAST-INFO-SERVICE/api/v1/yeast/" + yeastId,
                        Yeast.class);
        return yeastCollection;
    }

    public Yeast fallbackYeastItem(String recipeId) {
        return new Yeast("Default", "None");
    }
}
