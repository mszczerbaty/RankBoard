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
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String authorname;
    private String authorsurname;
    private String shortbio;
    @JsonIgnore
    @ManyToMany(mappedBy = "authors")
    private List<BoardGame> boardgames;

    public Author(String authorname, String authorsurname, String shortbio) {
        this.authorname = authorname;
        this.authorsurname = authorsurname;
        this.shortbio = shortbio;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", authorname='" + authorname + '\'' +
                ", authorsurname='" + authorsurname + '\'' +
                ", shortbio='" + shortbio + '\'' +
                '}';
    }
}
