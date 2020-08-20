package com.crafters.ratingsrecipeservice.resources;

import com.crafters.ratingsrecipeservice.dao.PostsRepository;
import com.crafters.ratingsrecipeservice.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class PostsResource {

    @Autowired
    private PostsRepository repository;

    @RequestMapping("/")
    public List<Post> getAllHops() {
        return repository.findAll();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Post addPost(@RequestBody Post newPost) {
        return repository.save(newPost);
    }

}
