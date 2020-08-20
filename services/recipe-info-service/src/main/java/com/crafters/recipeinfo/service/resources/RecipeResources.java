package com.crafters.recipeinfo.service.resources;

import com.crafters.recipeinfo.service.dao.RecipeRepository;
import com.crafters.recipeinfo.service.model.Recipe;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping("/api/v1/recipes")
public class RecipeResources {

    @Autowired
    private RecipeRepository repository;

    @RequestMapping("/{recipeName}")
    public Recipe getCatalog(@PathVariable("recipeName") String recipeName) {
        return repository.findByName(recipeName);
    }

    @RequestMapping("/")
    public List<Recipe> getAllRecipes() {
        return repository.findAll();
    }
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Recipe addRecipe (@RequestBody Recipe newRecipe) {
        return repository.save(newRecipe);
    }
}
