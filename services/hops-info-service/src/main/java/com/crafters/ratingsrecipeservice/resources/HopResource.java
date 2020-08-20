package com.crafters.ratingsrecipeservice.resources;

import com.crafters.ratingsrecipeservice.dao.HopRepository;
import com.crafters.ratingsrecipeservice.model.Hop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hops")
public class HopResource {

    @Autowired
    private HopRepository repository;

    @RequestMapping("/{hopName}")
    public Hop getHopById(@PathVariable("hopName") String hopName)  {
        return repository.findByName(hopName);
    }

    @RequestMapping("/")
    public List<Hop> getAllHops() {
        return repository.findAll();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Hop addHop (@RequestBody Hop newHop) {
        return repository.save(newHop);
    }

}
