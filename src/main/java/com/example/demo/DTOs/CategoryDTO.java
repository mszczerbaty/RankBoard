package com.example.demo.DTOs;

import com.example.demo.Entities.BoardGame;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {
    private int id;
    private String category;
    private List<BoardGame> boardgames;
}
