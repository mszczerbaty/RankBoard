package com.example.demo.Repositories;

import com.example.demo.DTOs.ScoreAvgDTO;
import com.example.demo.DTOs.ScoreCountDTO;
import com.example.demo.Entities.Score;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreRepo extends CrudRepository<Score, Integer> {

    @Query("SELECT s FROM Score s WHERE s.boardgame.id=:gameId")
    List<Score> getScoresByGameId(@Param("gameId")int gameId);

    @Query("SELECT new com.example.demo.DTOs.ScoreAvgDTO (AVG(s.score), s.boardgame.id) " +
            "FROM Score s GROUP BY s.boardgame.id ORDER BY AVG(s.score) DESC")
    List<ScoreAvgDTO> getTopAverageScores();

    @Query("SELECT CASE WHEN COUNT(*) > 0 THEN TRUE ELSE FALSE END FROM Score s WHERE s.boardgame.id=:gameId and s.username=:username")
    boolean findScoreByUsername(@Param("gameId")int gameId, @Param("username")String username);

    @Query("SELECT new com.example.demo.DTOs.ScoreCountDTO (s.boardgame.id, COUNT(s.score)) FROM Score s GROUP BY s.boardgame.id")
    List<ScoreCountDTO> countScores();
}
