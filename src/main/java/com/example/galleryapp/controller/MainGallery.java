package com.example.galleryapp.controller;

import com.example.galleryapp.entity.Image;
import com.example.galleryapp.repository.ImageInterface;
import com.example.galleryapp.service.ImageUploader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
public class MainGallery {

    private final ImageInterface imageInterface;

    private final ImageUploader imageUploader;

    @Autowired
    public MainGallery(ImageInterface imageInterface, ImageUploader imageUploader) {
        this.imageInterface = imageInterface;
        this.imageUploader = imageUploader;
    }

    @PostMapping("/file")
    public String saveObject(@RequestParam("url") String url,@RequestParam("name") String name, @RequestParam("price") Integer price,
                             @RequestParam("description") String description, @RequestParam("year") String year, @RequestParam("category") String category) throws IOException {

        imageUploader.saveObject(url, name, category ,price, description, year);
        return "test";
}

    @GetMapping("/gallery")
    public String showAllImages(Model model){


        List<Image> fileList = imageUploader.getAllImages();
        model.addAttribute("docs", fileList);
        return "test";
    }



}
