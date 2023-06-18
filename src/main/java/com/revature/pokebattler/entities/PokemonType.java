package com.revature.pokebattler.entities;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
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
@Table(name="pokemonType")
public class PokemonType {
    @Id
    private String id;

    @Column(nullable = false, unique = true)
    private String type;

    @OneToMany(mappedBy = "pokemonType", fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<Pokemon> pokemon;
}
