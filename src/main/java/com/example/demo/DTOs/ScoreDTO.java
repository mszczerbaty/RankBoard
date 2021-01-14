package com.example.demo.DTOs;

import com.example.demo.Entities.BoardGame;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScoreDTO {

    private int id;
    private int score;
    private String review;
    private String username;
    private BoardGame boardgame;
}
