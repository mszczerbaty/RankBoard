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
    private String players;
    @Lob
    private String description;
    private int forage;
    @Lob
    private String imageLink;

    @JsonIgnore
    @ManyToMany(mappedBy = "boardgames", cascade = CascadeType.ALL)
    private List<Category> categories;

    @JsonIgnore
    @ManyToMany(mappedBy = "boardgames", cascade = CascadeType.ALL) //cascade type will be changed
    private List<Author> authors;

    @JsonIgnore
    @OneToMany(mappedBy = "boardgame", cascade = CascadeType.ALL)
    private List<Extension> extensions;

    @JsonIgnore
    @OneToMany(mappedBy = "boardgame", cascade = CascadeType.ALL)
    private List<Score> scores;

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
                ", imageLink='" + imageLink + '\'' +
                '}';
    }
}
