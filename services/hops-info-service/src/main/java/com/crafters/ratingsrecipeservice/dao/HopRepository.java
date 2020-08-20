package com.crafters.ratingsrecipeservice.dao;

import com.crafters.ratingsrecipeservice.model.Hop;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface HopRepository extends MongoRepository<Hop, String> {
    public Hop findByName(String name);
    public List<Hop> findByForm(String form);
}
