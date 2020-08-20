package com.crafters.recipecatalogservice.models;

public class Hop {
    private String name;
    private String form;

    public Hop() {
    }

    public Hop(String name, String form) {
        this.name = name;
        this.form = form;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }
}
