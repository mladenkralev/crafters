package com.crafters.ratingsrecipeservice.model;

import org.springframework.data.annotation.Id;

public class Post {
    @Id
    public String id;

    private String text;

    private String image;

    public Post() { }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id='" + id + '\'' +
                ", text='" + text + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
