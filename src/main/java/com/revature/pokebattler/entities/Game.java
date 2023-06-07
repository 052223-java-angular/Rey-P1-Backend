package com.revature.pokebattler.entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="games")
public class Game {
    @Id
    private String game_id;


    @ManyToOne
    @JoinColumn(name="user_id")
    @JsonBackReference
    private User user;

    @Column(name="game_date", nullable = false)
    private Date game_date;

    @ManyToOne
    @JoinColumn(name="result_id")
    @JsonBackReference
    private Result result;

    @Column(name="game_pokemon_id")
    private String game_pokemon_id;
}
