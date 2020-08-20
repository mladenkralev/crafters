package com.crafters.recipecatalogservice.resources;

import com.crafters.recipecatalogservice.models.CatalogRecipe;
import com.crafters.recipecatalogservice.models.Fermentables;
import com.crafters.recipecatalogservice.models.Hop;
import com.crafters.recipecatalogservice.models.Recipe;
import com.crafters.recipecatalogservice.models.Yeast;
import com.crafters.recipecatalogservice.services.FermentableInfo;
import com.crafters.recipecatalogservice.services.HopsInfo;
import com.crafters.recipecatalogservice.services.RecipeInfo;
import com.crafters.recipecatalogservice.services.YeastInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class RecipeCatalogController {

    @Autowired
    public RestTemplate restTemplate;

    @Autowired
    RecipeInfo recipeInfo;

    @Autowired
    FermentableInfo fermentableInfo;

    @Autowired
    HopsInfo hopsInfo;

    @Autowired
    YeastInfo yeastInfo;

    @RequestMapping("/{recipeId}")
    public CatalogRecipe getCatalog(@PathVariable("recipeId") String recipeId) {
        Recipe recipe = recipeInfo.getRecipeItem(recipeId);

        // recipe can have N hops, every of the hops is reprsented as some collection, since apis does not guarantee uniqueness
        List<Hop> hops = recipe.getHopNames().stream().map(hop -> hopsInfo.getHopItem(hop)).collect(Collectors.toList());
        List<Yeast> yeasts = recipe.getYeastNames().stream().map(yeast -> yeastInfo.getYeastItem(yeast)).collect(Collectors.toList());
        List<Fermentables> fermetables = recipe.getFermentableNames().stream().map(ferm -> fermentableInfo.getFermentableItem(ferm)).collect(Collectors.toList());

        return new CatalogRecipe(recipe, hops, yeasts, fermetables);
    }
}
