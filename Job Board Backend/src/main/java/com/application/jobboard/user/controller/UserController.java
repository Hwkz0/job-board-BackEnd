package com.application.jobboard.user.controller;

import com.application.jobboard.auth.exception.EntityNotFoundException;
import com.application.jobboard.user.domain.User;
import com.application.jobboard.user.repository.UserRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final String entityType = "User";

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user/register")
    User newUser(@RequestBody User registerUser) {

        return userRepository.save(registerUser);

    }

    @GetMapping("/user/all-users")
    List<User> getAllUsers() {

        return userRepository.findAll();

    }


    @GetMapping("/user/{getUserById}")
    User getUserById(Long getUserById) {

        return userRepository.findById(getUserById)
                .orElseThrow(() -> new EntityNotFoundException(getUserById, entityType));

    }


    @PutMapping("/user/update/{idOfUserToBeUpdated}")
    User updateUser(@RequestBody User updateUser, @PathVariable Long idOfUserToBeUpdated) {

       return userRepository.findById(idOfUserToBeUpdated)
               .map(user -> {

                     user.setUserName(updateUser.getUserName());

                     user.setUserEmailAddress(updateUser.getUserEmailAddress());

                     user.setUserPassword(updateUser.getUserPassword());

                     user.setUserPhoneNumber(updateUser.getUserPhoneNumber());

                     return userRepository.save(user);

                })

               .orElseThrow(() -> new EntityNotFoundException(idOfUserToBeUpdated, entityType));

    }


    @DeleteMapping("/user/delete/{deleteUserId}")
    String deleteUser(@PathVariable Long deleteUserId) {

        if (userRepository.existsById(deleteUserId)) {

            userRepository.deleteById(deleteUserId);
            return "User with id "+ deleteUserId + "deleted successfully.";

        } else {

            throw new EntityNotFoundException(deleteUserId, entityType);

        }

    }



}
