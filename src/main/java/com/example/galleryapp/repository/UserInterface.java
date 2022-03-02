package com.example.galleryapp.repository;

import com.example.galleryapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
public interface UserInterface extends JpaRepository<User, Long> {
}
