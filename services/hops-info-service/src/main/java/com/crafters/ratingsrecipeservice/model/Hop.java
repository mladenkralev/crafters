package com.crafters.ratingsrecipeservice.model;

import org.springframework.data.annotation.Id;

public class Hop {
    @Id
    public String id;

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

    @Override
    public String toString() {
        return "Hop{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", form='" + form + '\'' +
                '}';
    }
}
