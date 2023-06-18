package com.revature.pokebattler.entities;

import java.util.Date;

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

    @OneToMany(mappedBy="game", fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<Game_Pokemon> game_pokemon;
}
