package com.example.galleryapp.controller;


import com.example.galleryapp.entity.Image;
import com.example.galleryapp.image.ImageInterface;
import com.example.galleryapp.image.ImageUploader;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("http://localhost:4200")
public class MainGallery {

    private final ImageUploader imageUploader;



    @PostMapping("/file")
    public Image saveObject(@RequestBody Image image) throws IOException {

       return imageUploader.saveObject(image);
}

    @GetMapping("/file")
    public List<Image> showAllImages(Model model){

        List<Image> fileList = imageUploader.getAllImages();
        model.addAttribute("docs", fileList);
        return fileList;
    }



}
