package com.crafters.recipecatalogservice.services;

import com.crafters.recipecatalogservice.models.Recipe;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RecipeInfo {

    @Autowired
    public RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallbackRecipeItem",
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
    public Recipe getRecipeItem(String recipeId) {
        Recipe recipe =
                restTemplate.getForObject("http://RECIPE-INFO-SERVICE/api/v1/recipes/" + recipeId,
                        Recipe.class);
        return recipe;
    }

    public Recipe fallbackRecipeItem(String recipeId) {
        return new Recipe("Default", "None");
    }
}
