package com.revature.pokebattler.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
@Table(name="game_pokemon")
public class Game_Pokemon{
    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name="game_id")
    @JsonBackReference
    private Game game;

    @ManyToOne
    @JoinColumn(name="pokemon_id")
    @JsonBackReference
    private Pokemon pokemon;
}