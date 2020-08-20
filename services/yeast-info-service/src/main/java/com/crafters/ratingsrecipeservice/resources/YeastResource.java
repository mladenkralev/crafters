package com.crafters.ratingsrecipeservice.resources;

import com.crafters.ratingsrecipeservice.dao.YeastsRepository;
import com.crafters.ratingsrecipeservice.model.Yeast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("api/v1/yeast")
public class YeastResource {

    @Autowired
    private YeastsRepository repository;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{yeastName}")
    public Yeast getYeast(@PathVariable("yeastName") String yeastName) {
        return repository.findByName(yeastName);
    }

    @RequestMapping("/")
    public List<Yeast> getAllYeasts() {
        return repository.findAll();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Yeast addHop(@RequestBody Yeast newYeast) {
        return repository.save(newYeast);
    }
}
