package com.crafters.recipecatalogservice.services;

import com.crafters.recipecatalogservice.models.Fermentables;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FermentableInfo {

    @Autowired
    public RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallbackFermentableItem",
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
    public Fermentables getFermentableItem(String fermentableItem) {
        Fermentables hopCollection =
                restTemplate.getForObject("http://FERMETABLES-INFO-SERVICE/api/v1/fermentables/" + fermentableItem,
                        Fermentables.class);
        return hopCollection;
    }

    public Fermentables fallbackFermentableItem(String recipeId) {
        return new Fermentables("Default", "None");
    }
}
