package com.ashish.controllers;

import com.ashish.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserControllers {

    @GetMapping("/getUser/{id}")
    public ResponseEntity<User> getUser( @PathVariable String id){
        return ResponseEntity.ok(new User("ashish","1"));
    }
    @PostMapping("/createUsers")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        return ResponseEntity.ok(user);
    }
}
