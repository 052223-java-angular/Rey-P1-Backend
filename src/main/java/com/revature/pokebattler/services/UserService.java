package com.revature.pokebattler.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.revature.pokebattler.entities.User;
import com.revature.pokebattler.repositories.UserRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepo;
    public boolean isUniqueUnsername(String username){
        Optional<User> userOpt = userRepo.findByUsername(username);
        return userOpt.isEmpty();
    }
}
