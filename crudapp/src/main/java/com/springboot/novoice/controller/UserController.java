package com.springboot.novoice.controller;

import com.springboot.novoice.entity.User;
import com.springboot.novoice.exception.UserNotFoundException;
import com.springboot.novoice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/users")
    public ResponseEntity<?> addUser(@RequestBody User user){
        if(user != null) {
            User savedUser = userService.save(user);
            URI uri = ServletUriComponentsBuilder.
                    fromCurrentRequest().
                    path("/{id}").
                    buildAndExpand(savedUser.getId()).toUri();
            return ResponseEntity.created(uri).build();
        }
        throw new UserNotFoundException();
    }

    @GetMapping("/users")
    public List<User> retrieveUsers(){
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable Long id){
        User user = userService.findUser(id);
        if(user == null){
            throw new UserNotFoundException();
        }
        return user;
    }

    @DeleteMapping("/users/{id}")
    public User deleteUser(@PathVariable Long id){
        User user = userService.findUser(id);
        if(user == null){
            throw new UserNotFoundException();
        }
        userService.delete(user.getId());

        return user;
    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User user){
        User newUser = userService.update(user);
        if(newUser == null){
            throw new UserNotFoundException();
        }
        return newUser;
    }
}
