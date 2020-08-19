package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "boardgames")
public class BoardGame {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String boardgamename;
    private int publishyear;
    private int estplaytime;
    private int players;
    private String description;
    private int forage;
    //private double score; avg from another table
    //private long rank; to be determined

    public BoardGame(String boardgamename, int publishyear, int estplaytime, int players, String description, int forage) {
        this.boardgamename = boardgamename;
        this.publishyear = publishyear;
        this.estplaytime = estplaytime;
        this.players = players;
        this.description = description;
        this.forage = forage;
    }

    @Override
    public String toString() {
        return "BoardGame{" +
                "id=" + id +
                ", boardgamename='" + boardgamename + '\'' +
                ", publishyear=" + publishyear +
                ", estplaytime=" + estplaytime +
                ", players=" + players +
                ", description='" + description + '\'' +
                ", forage=" + forage +
                '}';
    }
}
