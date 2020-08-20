package com.crafters.recipecatalogservice.models;

import java.util.ArrayList;
import java.util.List;

public class Recipe {
    private String name;
    private String type;
    private List<String> hopNames = new ArrayList<>();
    private List<String> yeastNames = new ArrayList<>();
    private List<String> fermentableNames = new ArrayList<>();

    public Recipe() {
    }

    public Recipe(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public Recipe(String name, String type, List<String> hopNames, List<String> yeastNames, List<String> fermentableNames) {
        this.name = name;
        this.type = type;
        this.hopNames = hopNames;
        this.yeastNames = yeastNames;
        this.fermentableNames = fermentableNames;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getHopNames() {
        return hopNames;
    }

    public void setHopNames(List<String> hopNames) {
        this.hopNames = hopNames;
    }

    public List<String> getYeastNames() {
        return yeastNames;
    }

    public void setYeastNames(List<String> yeastNames) {
        this.yeastNames = yeastNames;
    }

    public List<String> getFermentableNames() {
        return fermentableNames;
    }

    public void setFermentableNames(List<String> fermentableNames) {
        this.fermentableNames = fermentableNames;
    }
}
