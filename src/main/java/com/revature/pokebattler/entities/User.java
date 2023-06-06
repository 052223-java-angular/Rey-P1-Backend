package com.revature.pokebattler.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="users")
public class User {
    @Column(nullable = false, length = 10)
    private String username;

    @Column
    private String pasword;

    @Id
    private String id;


    @ManyToOne
    @JoinColumn(name ="role_id")
    @JsonBackReference
    private Role role; 
}
