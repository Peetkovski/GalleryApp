package com.example.galleryapp.repository;

import com.example.galleryapp.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin("http://localhost:4200")
public interface ImageInterface extends JpaRepository<Image, Long> {

    List<Image> findByCategory(String category);
}
