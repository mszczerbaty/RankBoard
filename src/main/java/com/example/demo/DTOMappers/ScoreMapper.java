package com.example.demo.DTOMappers;


import com.example.demo.DTOs.ScoreDTO;
import com.example.demo.Entities.Score;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ScoreMapper {

    ScoreDTO toScoreDTO(Score score);
    Score toScore(ScoreDTO scoreDTO);
    List<ScoreDTO> toScoreDTOs(List<Score> scores);
}
