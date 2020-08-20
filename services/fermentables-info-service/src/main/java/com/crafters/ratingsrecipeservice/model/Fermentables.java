package com.crafters.ratingsrecipeservice.model;

public class Fermentables {
    private String name;
    private String type;

    public Fermentables(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public Fermentables() {
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
}
