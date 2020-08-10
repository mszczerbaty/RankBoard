package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardGame {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String boardgamename;

    public BoardGame(String boardgamename) {
        this.boardgamename = boardgamename;
    }

    @Override
    public String toString() {
        return "BoardGame{" +
                "id=" + id +
                ", boardgamename='" + boardgamename + '\'' +
                '}';
    }
}
