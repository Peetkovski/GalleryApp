package com.example.galleryapp;

import com.example.galleryapp.entity.User;
import com.example.galleryapp.user.UserInterface;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class GalleryAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(GalleryAppApplication.class, args);
    }

}
