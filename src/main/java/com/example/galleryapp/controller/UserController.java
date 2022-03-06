package com.example.galleryapp.controller;

import com.example.galleryapp.entity.Image;
import com.example.galleryapp.entity.User;
import com.example.galleryapp.user.UserInterface;
import com.example.galleryapp.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("http://localhost:4200")

public class UserController {

    private final UserService userService;

    @PostMapping("/users")
    public void addUser(@RequestBody User user) {

       userService.addUser(user);
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.showAllUsers();
    }
}
