package com.crafters.recipeinfo.service.dao;

import com.crafters.recipeinfo.service.model.Recipe;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface RecipeRepository extends MongoRepository<Recipe, String> {
    public Recipe findByName(String name);
    public List<Recipe> findByType(String type);
}
