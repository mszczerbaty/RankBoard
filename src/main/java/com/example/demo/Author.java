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
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String authorname;

    public Author(String authorname) {
        this.authorname = authorname;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", authorname='" + authorname + '\'' +
                '}';
    }
}
