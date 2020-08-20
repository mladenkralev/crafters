package com.crafters.ratingsrecipeservice.model;

import org.springframework.data.annotation.Id;

public class Yeast {
    @Id
    public String id;

    private String name;
    private String type;

    public Yeast(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public Yeast() {
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
