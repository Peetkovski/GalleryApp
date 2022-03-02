package com.example.galleryapp.controller;

import com.example.galleryapp.entity.Image;
import com.example.galleryapp.repository.ImageInterface;
import com.example.galleryapp.service.ImageUploader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class MainGallery {

    @Autowired
    private ImageInterface imageInterface;

    @Autowired
    private ImageUploader imageUploader;




    @GetMapping("/gallery")
    public String showAllImages(Model model){


        List<Image> fileList = imageUploader.getAllImages();
        model.addAttribute("docs", fileList);
        return "test";
    }



}
