package com.example.demo.Services;

import com.example.demo.DTOs.ScoreAvgDTO;
import com.example.demo.DTOs.ScoreCountDTO;
import com.example.demo.Entities.Score;
import com.example.demo.Repositories.ScoreRepo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {

    private ScoreRepo scoreRepo;

    public ScoreService(ScoreRepo scoreRepo) {
        this.scoreRepo = scoreRepo;
    }

    public boolean save(@RequestBody Score score) {
        //check if user already added review
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails) principal).getUsername();

        if (scoreRepo.findScoreByUsername(score.getBoardgame().getId(), username)) {
            return false;
        } else {
            score.setUsername(username);
            System.out.println(username);//
            scoreRepo.save(score);
            return true;
        }
    }

    public List<Score> findAll() {
        return (List<Score>) scoreRepo.findAll();
    }

    public Optional<Score> findById(@PathVariable int scoreId) {
        return scoreRepo.findById(scoreId);
    }

    public void delete(@PathVariable int scoreId) {
        scoreRepo.deleteById(scoreId);
    }

    public List<ScoreAvgDTO> topAverageScores() {
        return scoreRepo.getTopAverageScores();
    }

    public List<Score> getScoresByGameId(@PathVariable int gameId) {
        return scoreRepo.getScoresByGameId(gameId);
    }

    public List<ScoreCountDTO> countScores() {
        return scoreRepo.countScores();
    }
}
