package com.example.galleryapp.service;

import com.example.galleryapp.entity.Image;
import com.example.galleryapp.repository.ImageInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ImageUploader {

    @Autowired
    private ImageInterface imageInterface;


    public Optional<Image> getFile(Long imageId){
        return imageInterface.findById(imageId);
    }

    public List<Image> getAllImages(){
        return imageInterface.findAll();
    }

    public Image addImage(Image image){

        return imageInterface.save(image);
    }

}
