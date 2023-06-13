package com.revature.pokebattler.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.pokebattler.dtos.requests.NewLoginRequest;
import com.revature.pokebattler.dtos.requests.NewUserRequest;
import com.revature.pokebattler.dtos.responses.Principal;
import com.revature.pokebattler.services.JwtTokenService;
import com.revature.pokebattler.services.UserService;
import com.revature.pokebattler.utils.custom_exceptions.ResourceConflictException;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;
    private final JwtTokenService tokenService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody NewUserRequest req){
        if(!userService.isValidUsername(req.getUsername())){
            throw new ResourceConflictException("Username must fit the criteria");
        }

        if(!userService.isUniqueUsername(req.getUsername())){
            throw new ResourceConflictException("Username is not unique");
        }

        if(!userService.isValidPassword(req.getPassword())){
            throw new ResourceConflictException("Password must fit the criteria");
        }

        if(!userService.isSamePassword(req.getPassword(), req.getConfirmPassword())){
            throw new ResourceConflictException("Passwords must match");
        }

        userService.registerUser(req);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
    @PostMapping("/login")
    public ResponseEntity<Principal> login(@RequestBody NewLoginRequest req){
        Principal principal = userService.login(req);

        String token = tokenService.generateToken(principal);

        principal.setToken(token);

        return ResponseEntity.status(HttpStatus.OK).body(principal);
    }
    // @GetMapping

    // @PutMapping
    // @DeleteMapping

    
}
