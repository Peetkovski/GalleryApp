package com.example.galleryapp.repository;

import com.example.galleryapp.entity.Gender;
import com.example.galleryapp.entity.User;
import com.example.galleryapp.image.ImageNotFoundException;
import com.example.galleryapp.user.EmailFoundException;
import com.example.galleryapp.user.UserInterface;
import com.example.galleryapp.user.UserNotFoundException;
import com.example.galleryapp.user.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
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
class UserInterfaceTest {

    @Mock
    private UserInterface userInterface;
    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserService(userInterface);
    }

    @Test
    void canAddUser() {
        User user = new User(
                "Peter",
                "PeterB@gmail.com"
        );
        userService.addUser(user);
        ArgumentCaptor<User> argumentCaptor =
                ArgumentCaptor.forClass(User.class);

        Mockito.verify(userInterface)
                .save(argumentCaptor.capture());

        User capturedUser = argumentCaptor.getValue();
        Assertions.assertEquals(capturedUser, user);
    }

    @Test
    void willThrowEmailFoundException(){
        User user = new User(
                "Peter",
                "PeterB@gmail.com"
        );
        given(userInterface.selectExistsEmail(user.getEmail()))
                .willReturn(true);
        assertThatThrownBy(() -> userService.addUser(user))
                .isInstanceOf(EmailFoundException.class)
                .hasMessageContaining("User with email: " + user.getEmail() + " already exists!");

        verify(userInterface, never()).save(any());
    }


    @Test
    void canGetUserById(){
        userService.getUserById(1L);

        Mockito.verify(userInterface).findById(1L);

    }

    @Test
    void willThrowUserNotFoundException(){
        User user = new User(
                "Peter",
                "PeterB@gmail.com"
        );

        given(userInterface.findUserById(user.getId()))
                .willReturn(true);
        assertThatThrownBy(() -> userService.getUserById(user.getId()))
                .isInstanceOf(UserNotFoundException.class)
                .hasMessageContaining("User with: " + user.getId() + " id, not found");

        verify(userInterface, never()).save(any());
    }


}
