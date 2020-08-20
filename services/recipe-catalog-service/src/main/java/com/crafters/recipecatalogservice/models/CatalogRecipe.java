package com.crafters.recipecatalogservice.models;

import java.util.List;

public class CatalogRecipe {
    private Recipe recipe;

    // TODO prob a better naming?
    private List<Hop> hopCollection;
    private List<Yeast> yeastCollection;
    private List<Fermentables> fermentablesCollection;

    public CatalogRecipe(Recipe recipe, List<Hop> hopCollection, List<Yeast> yeastCollection, List<Fermentables> fermentablesCollection) {
        this.recipe = recipe;
        this.hopCollection = hopCollection;
        this.yeastCollection = yeastCollection;
        this.fermentablesCollection = fermentablesCollection;
    }

    public CatalogRecipe() {
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public List<Hop> getHopCollection() {
        return hopCollection;
    }

    public void setHopCollection(List<Hop> hopCollection) {
        this.hopCollection = hopCollection;
    }

    public List<Yeast> getYeastCollection() {
        return yeastCollection;
    }

    public void setYeastCollection(List<Yeast> yeastCollection) {
        this.yeastCollection = yeastCollection;
    }

    public List<Fermentables> getFermentablesCollection() {
        return fermentablesCollection;
    }

    public void setFermentablesCollection(List<Fermentables> fermentablesCollection) {
        this.fermentablesCollection = fermentablesCollection;
    }
}
