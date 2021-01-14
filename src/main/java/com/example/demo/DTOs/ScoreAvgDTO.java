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
public class ScoreAvgDTO {

    private double score;
    private int boardgameId;
}
