package com.revature.pokebattler.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.pokebattler.dtos.requests.NewRoleRequest;
import com.revature.pokebattler.services.RoleService;
import com.revature.pokebattler.utils.custom_exceptions.ResourceConflictException;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/role")
@CrossOrigin(origins = "", allowedHeaders = "")
@AllArgsConstructor
public class RoleController {
    private final RoleService roleService;

    @PostMapping("/create")
    public ResponseEntity<?> createRole(@RequestBody NewRoleRequest req){
        if(!roleService.isUniqueRole(req.getName())){
            throw new ResourceConflictException("Role " + req.getName() + "already exists");
        }
        roleService.saveRole(req);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @ExceptionHandler(ResourceConflictException.class)
    public ResponseEntity<Map<String, Object>> handleResourceConflictException(ResourceConflictException e){
        Map<String, Object> map = new HashMap<>();
        map.put("timestamp", new Date(System.currentTimeMillis()));
        map.put("message", e.getMessage());

        return ResponseEntity.status(HttpStatus.CONFLICT).body(map);
    }
}
