package com.crafters.ratingsrecipeservice.dao;

import com.crafters.ratingsrecipeservice.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface PostsRepository extends MongoRepository<Post, String> { }
