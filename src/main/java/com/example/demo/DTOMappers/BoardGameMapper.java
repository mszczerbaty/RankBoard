package com.example.demo.DTOMappers;


import com.example.demo.DTOs.BoardGameDTO;
import com.example.demo.Entities.BoardGame;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BoardGameMapper {

    BoardGameDTO toBoardGameDTO(BoardGame boardGame);
    BoardGame toBoardGame(BoardGameDTO boardGameDTO);
    List<BoardGameDTO> toBoardGameDTOs(List<BoardGame> boardGames);
}
