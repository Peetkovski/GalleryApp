package com.example.galleryapp.user;

import com.example.galleryapp.entity.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class UserService {

    private final UserInterface userInterface;


    @Transactional
    public void addUser(User user){

        Boolean emailExists = userInterface.selectExistsEmail(user.getEmail());
        if(emailExists){
            log.warn("User with: " + user.getEmail() + " email, is already in use!");
            throw new EmailFoundException(
                    "User with email: " + user.getEmail() + " already exists!"
            );
        }
         userInterface.save(user);
    }

    public Optional<User> getUserById(Long userId){

        Boolean idExists = userInterface.findUserById(userId);
        if(idExists){
            log.warn("User with: " + userId + " id, not found");
            throw new UserNotFoundException(
                "User with: " + userId + " id, not found"

            );
        }
        return userInterface.findById(userId);
    }

    public List<User> showAllUsers(){

        return (List<User>) userInterface.findAll();

    }
}
