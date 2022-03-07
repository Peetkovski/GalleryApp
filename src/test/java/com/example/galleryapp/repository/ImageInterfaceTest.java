package com.example.galleryapp.repository;

import com.example.galleryapp.entity.Categories;
import com.example.galleryapp.entity.Image;
import com.example.galleryapp.image.ImageInterface;
import com.example.galleryapp.image.ImageNotFoundException;
import com.example.galleryapp.image.ImageUploader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ImageInterfaceTest {

    @Mock
    private ImageUploader imageUploader;
    @Mock
    private ImageInterface imageInterface;


    @BeforeEach
    void setUp() {

        imageUploader = new ImageUploader(imageInterface);

    }

    @Test
    void getAllFiles(){

        imageUploader.getAllImages();

        Mockito.verify(imageInterface).findAll();

    }
    @Test
    void canAddImage(){
        Image image = new Image(
                "Bonaparte",
                "Painting of bonaparte",
                "1804",
              "Historic",
                "http://s.ciekawostkihistoryczne.pl/uploads/2017/05/Napoleon.jpg",
                1250
        );
        imageUploader.saveObject(image);
        ArgumentCaptor<Image> argumentCaptor =
                ArgumentCaptor.forClass(Image.class);

        Mockito.verify(imageInterface)
                .save(argumentCaptor.capture());

        Image capturedImage = argumentCaptor.getValue();
        Assertions.assertEquals(capturedImage, image);
    }

    @Test
    @Disabled
    void willThrowExceptionImageAddNotFound(){
        Image image = new Image(
                "Owczarek niemcki",
                "Painting of bonaparte",
                "1804",
                "Historic",
                "http://s.ciekawostkihistoryczne.pl/uploads/2017/05/Napoleon.jpg",
                1250);
        given(imageInterface.findImageByName(image.getName()))
                .willReturn(true);

        assertThatThrownBy(() -> imageUploader.saveObject(image))
                .isInstanceOf(ImageNotFoundException.class)
                .hasMessageContaining("Image was found!");

        verify(imageInterface, never()).save(any());
    }




    @Test
    void willThrowExceptionDelete(){
        Image image = new Image(
                "Bonaparte",
                "Painting of bonaparte",
                "1804",
                "Historic",
                "http://s.ciekawostkihistoryczne.pl/uploads/2017/05/Napoleon.jpg",
                1250
        );
        imageInterface.save(image);

       assertThatThrownBy(() -> imageUploader.deleteFile(image.getId()))
               .isInstanceOf(ImageNotFoundException.class)
               .hasMessageContaining("Image with Id " + image.getId() + " Not found!");

        verify(imageInterface, never()).delete(any());


    }


    @Test
    @Disabled
    void canDeleteImage(){
        Image image = new Image(
                "Bonaparte",
                "Painting of bonaparte",
                "1804",
                "historic",
                "http://s.ciekawostkihistoryczne.pl/uploads/2017/05/Napoleon.jpg",
                1250
        );
        imageUploader.deleteFile(image.getId());
        ArgumentCaptor<Image> argumentCaptor =
                ArgumentCaptor.forClass(Image.class);

        Mockito.verify(imageInterface)
                .delete(argumentCaptor.capture());

        Image capturedImage = argumentCaptor.getValue();
        //TODO NAPISZ TESTY DO USUWANIA!
    }

}
