package com.revature.pokebattler.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.pokebattler.dtos.requests.NewUserRequest;
import com.revature.pokebattler.services.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {
    //private final UserService userService;
    /*
    @PostMapping("/login")
    public ResponseEntity<?> registerUser(@RequestBody NewUserRequest req){
        //if(!userService.isUniqueUnsername(req.getUsername())){
        //    throw new Exception(null);
        //}
    }
    // @GetMapping

    // @PutMapping
    // @DeleteMapping

    
}*/}
