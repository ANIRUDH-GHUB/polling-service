package com.au.polling.controller;
import com.au.polling.model.User;
import com.au.polling.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.util.ObjectUtils.isEmpty;

@RestController
@RequestMapping("/user")
public class Controller {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<?> addUser(@RequestBody User user){
        User save = userService.addUser(user);
        return ResponseEntity.ok(save);
    }

    @GetMapping("/get")
    public ResponseEntity<List<User>> getUser(){
        return ResponseEntity.ok(this.userService.findAll());
    }

    @GetMapping("/login")
    public ResponseEntity<Boolean> getUserById(@RequestParam(required = true) String username, @RequestParam(required = true) String password ){
        User user = userService.findByUsername(username);
        Boolean isValid = false;
        if(user != null){
            System.out.println(user.getPassword());
            if(user.getPassword().equals(password)){
                isValid = true;
            }
        }
        return ResponseEntity.ok(isValid);
    }



}
