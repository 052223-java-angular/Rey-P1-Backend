package com.revature.pokebattler.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.revature.pokebattler.dtos.requests.NewLoginRequest;
import com.revature.pokebattler.dtos.requests.NewUserRequest;
import com.revature.pokebattler.dtos.responses.Principal;
import com.revature.pokebattler.entities.Role;
import com.revature.pokebattler.entities.User;
import com.revature.pokebattler.repositories.UserRepository;
import com.revature.pokebattler.utils.custom_exceptions.UserNotFoundException;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepo;
    private final RoleService roleService;

    // Register a user
    public User registerUser(NewUserRequest req){
        Role foundRole = roleService.findByName("USER");
        String hashed = BCrypt.hashpw(req.getPassword(), BCrypt.gensalt());
        User newUser = new User(req.getUsername(), hashed, foundRole);

        return userRepo.save(newUser);
    }
    // Login a user
    public Principal login(NewLoginRequest req){
        Optional<User> userOpt = userRepo.findByUsername(req.getUsername());
        if(userOpt.isPresent()){
            User foundUser = userOpt.get();
            if( BCrypt.checkpw(req.getPassword(), foundUser.getPassword())){
                return new Principal(foundUser);
            }
        }
        throw new UserNotFoundException("Invalid Credentials");
    }

    public boolean isValidUsername(String username) {
        return username.matches("^(?=[a-zA-Z0-9._]{8,20}$)(?!.*[_.]{2})[^_.].*[^_.]$");
    }

    public boolean isValidPassword(String password) {
        return password.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$");
    }

    public boolean isUniqueUsername(String username){
        Optional<User> userOpt = userRepo.findByUsername(username);
        return userOpt.isEmpty();
    }
    public boolean isSamePassword(String password, String confirmPassword) {
        return password.equals(confirmPassword);
    }
}
