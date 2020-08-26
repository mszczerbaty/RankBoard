package com.example.demo.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "boardgames")
public class BoardGame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String boardgamename;
    private int publishyear;
    private int estplaytime;
    private int players;
    private String description;
    private int forage;

    @JsonIgnore //it may change based on the way of adding new records
    @ManyToMany(mappedBy = "boardgames", cascade = CascadeType.ALL)
    private List<Author> authors;

    @JsonIgnore
    @OneToMany(mappedBy = "boardgame", cascade = CascadeType.ALL)
    private List <Extension> extensions;

    //private double score; avg from another table
    @JsonIgnore
    @OneToMany(mappedBy = "boardgame", cascade = CascadeType.ALL)
    private List<Score> scores;

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
