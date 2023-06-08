package com.revature.pokebattler.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.pokebattler.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,String>{
    Optional<Role> findByName(String name);
}
