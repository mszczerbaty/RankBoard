package com.example.demo.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "scores")
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    //private int userId; //retrieve userid that scored a boardgame
    private int score;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "boardgame_id")
    private BoardGame boardgame;

    public Score(int score, BoardGame boardgame) {
        this.score = score;
        this.boardgame = boardgame;
    }

    @Override
    public String toString() {
        return "Score{" +
                "id=" + id +
                ", score=" + score +
                '}';
    }
}
