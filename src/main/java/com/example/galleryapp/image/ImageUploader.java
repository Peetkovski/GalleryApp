package com.example.galleryapp.image;

import com.example.galleryapp.entity.Image;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Slf4j
@AllArgsConstructor
public class ImageUploader {

    private final ImageInterface imageInterface;


    @Transactional
    public Image saveObject(Image image){
       return imageInterface.save(image);

        //TODO ZRÓB NORMALNE DODAWNIE ZDJEC

    }

    @Transactional
    public void deleteFile(Long imageId){

        if(!imageInterface.existsById(imageId)){
            log.warn("Image with id: " + imageId + " not found!");
            throw new ImageNotFoundException(
                    "Image with Id " + imageId + " Not found!"
            );
        }

         imageInterface.deleteById(imageId);
    }


    public List<Image> getAllImages(){
        return imageInterface.findAll();
    }



}
