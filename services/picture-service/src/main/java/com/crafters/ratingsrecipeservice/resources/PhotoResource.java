package com.crafters.ratingsrecipeservice.resources;

import com.crafters.ratingsrecipeservice.dao.PhotoRepository;
import com.crafters.ratingsrecipeservice.model.Photo;
import com.crafters.ratingsrecipeservice.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/photos")
public class PhotoResource {

    @Autowired
    private PhotoService photoService;

    @PostMapping("/add")
    public String addPhoto(@RequestParam("image") MultipartFile image, Model model)
            throws IOException {
        return photoService.addPhoto(image);
    }

}
