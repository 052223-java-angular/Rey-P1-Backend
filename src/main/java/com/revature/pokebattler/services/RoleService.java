package com.revature.pokebattler.services;

import org.springframework.stereotype.Service;

import com.revature.pokebattler.dtos.requests.NewRoleRequest;
import com.revature.pokebattler.entities.Role;
import com.revature.pokebattler.repositories.RoleRepository;
import com.revature.pokebattler.utils.custom_exceptions.RoleNotFoundException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RoleService {
    private final RoleRepository roleRepo;

    public Role findByName(String name){
        return roleRepo.findByName(name).orElseThrow(() -> new RoleNotFoundException("Role " + name + " was not found"));
    }

    public Role saveRole(NewRoleRequest req){
        Role newRole = new Role(req.getName());
        return roleRepo.save(newRole);
    }

    public boolean isUniqueRole(String name){
        return roleRepo.findByName(name).isEmpty();
    }
}
