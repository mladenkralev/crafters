package com.crafters.ratingsrecipeservice.resources;

import com.crafters.ratingsrecipeservice.dao.FermentablesRepository;
import com.crafters.ratingsrecipeservice.model.Fermentables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/fermentables")
public class FermentablesResource {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private FermentablesRepository repository;

    @RequestMapping("/{fermentablesName}")
    public Fermentables getFermentableById(@PathVariable("fermentablesName") String fermentablesName) {
        return repository.findByName(fermentablesName);

    }

    @RequestMapping("/")
    public List<Fermentables> getAllFermentables() {
        return repository.findAll();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Fermentables addFermentables (@RequestBody Fermentables newFermentable) {
        return repository.save(newFermentable);
    }
}
