package com.crafters.ratingsrecipeservice.model;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;

public class Photo {

    @Id
    private String id;

    private String title;

    private Binary image;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Binary getImage() {
        return image;
    }

    public void setImage(Binary image) {
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
