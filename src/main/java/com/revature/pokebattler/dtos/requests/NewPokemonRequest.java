package com.revature.pokebattler.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NewPokemonRequest {
    private String name;
    private int hp;
    private int attack;
    private int defense;
    private int specialDefense;
    private int specialAttack;
    private String typing;
}
