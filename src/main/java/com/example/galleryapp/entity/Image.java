package com.example.galleryapp.entity;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Image {

    @GeneratedValue()
    @Id
    private Long id;
    private String name;
    private String description;
    private String year;
    
    private String category;

    @Lob
    private String image;

    @Column(name = "price")
    private Integer price;
    @CreationTimestamp
    private Date dateCreated;

    public Image(String name, String description, String year, String category, String image, Integer price) {
        this.name = name;
        this.description = description;
        this.year = year;
        this.category = category;
        this.image = image;
        this.price = price;
    }



}
