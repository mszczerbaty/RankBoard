package com.example.demo.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardGameDTO {
    private int id;
    private String boardgamename;
    private int publishyear;
    private int estplaytime;
    private String players;
    private String description;
    private int forage;
    private String imageLink;
}
