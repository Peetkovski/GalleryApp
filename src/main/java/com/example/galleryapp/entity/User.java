package com.example.galleryapp.entity;

import lombok.*;

import javax.persistence.*;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class User {

    @GeneratedValue
    @Id
    @Column(name = "id")
    private Long id;
    private String name;
    private String email;


    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
