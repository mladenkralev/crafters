package com.crafters.ratingsrecipeservice.dao;

import com.crafters.ratingsrecipeservice.model.Fermentables;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface FermentablesRepository extends MongoRepository<Fermentables, String> {
    public Fermentables findByName(String name);

    public List<Fermentables> findByForm(String form);
}
