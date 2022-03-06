package com.example.galleryapp;

import com.example.galleryapp.entity.User;
import com.example.galleryapp.user.UserInterface;
import com.example.galleryapp.user.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

class GalleryAppApplicationTests {

    @Mock
    private UserInterface userInterface;

    private UserService userService;


    @BeforeEach
    void setUp() {
        userService = new UserService(userInterface);
    }

    @Test
    void addUser(){

        User user = new User(
                "Tom",
                "Tom@gmail.com"
        );
     userService.addUser(user);

    }

    @Test
    void showUser(){


        System.out.println( userInterface.findAll());
    }

}
