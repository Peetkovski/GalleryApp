package com.example.galleryapp.image;

import com.example.galleryapp.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Repository
@CrossOrigin("http://localhost:4200")
public interface ImageInterface extends JpaRepository<Image, Long> {

    List<Image> findByCategory(String category);
    Image findImageById(Long id);
    Boolean findImageByName(String name);

}
