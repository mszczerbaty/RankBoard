package com.example.demo.DTOs;

import com.example.demo.Entities.BoardGame;
import lombok.*;

import java.util.List;

//@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDTO {
    private int id;
    private String authorname;
    private String authorsurname;
    private String shortbio;
    private List<BoardGame> boardgames;
}
