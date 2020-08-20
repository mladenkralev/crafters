package com.crafters.ratingsrecipeservice.dao;

import com.crafters.ratingsrecipeservice.model.Yeast;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface YeastsRepository extends MongoRepository<Yeast, String> {
    public Yeast findByName(String name);
    public List<Yeast> findByType(String type);
}
