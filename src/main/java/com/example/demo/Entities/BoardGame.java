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
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "boardgames_authors",
            joinColumns = @JoinColumn(name = "boardgame_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "author_id", referencedColumnName = "id")
    )
    private List<Author> authors;

    @JsonIgnore
    @OneToMany(mappedBy = "boardgame")
    private List <Extenstion> extenstions;
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
