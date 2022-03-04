package com.example.galleryapp.service;

import org.springframework.util.StringUtils;
import com.example.galleryapp.entity.Image;
import com.example.galleryapp.repository.ImageInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ImageUploader {

    private final ImageInterface imageInterface;

    @Autowired
    public ImageUploader(ImageInterface imageInterface) {
        this.imageInterface = imageInterface;
    }

    public void saveObject(String url, String name, String category, Integer price, String year, String description) throws IOException {

        Image image = new Image();
        image.setImage(url);
        image.setDescription(description);
        image.setCategory(category);
        image.setName(name);
        image.setYear(year);
        image.setPrice(price);

        imageInterface.save(image);

        //TODO ZRÓB NORMALNE DODAWNIE ZDJEC

    }

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
