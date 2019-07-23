package com.whakahero.whakahero.controller;

import com.whakahero.whakahero.entity.User;
import com.whakahero.whakahero.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/user/create")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PostMapping("/user/login")
    public User login(@RequestBody User user) {
        return userRepository.findByNameAndPassword(user.getName(), user.getPassword());
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PutMapping("/user/{idUser}")
    public User updateScore(@PathVariable Long idUser, @RequestBody User userUpdate) {
        User user = userRepository.findById(idUser).get();
        user.setScoreMax(userUpdate.getScoreMax());
        return userRepository.save(user);
    }
}

