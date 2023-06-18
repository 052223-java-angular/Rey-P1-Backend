package com.revature.pokebattler.entities;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name="pokemon")
public class Pokemon {
    @Id
    private int pid;

    @Column(unique = true, nullable = false)
    private String pokemonName;

    @ManyToOne
    @JoinColumn(name="pokemonType_id")
    @JsonBackReference
    private PokemonType pokemonType;

    @OneToMany(mappedBy = "pokemon", fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<Game_Pokemon> game_pokemon;
}
