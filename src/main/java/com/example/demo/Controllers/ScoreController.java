package com.example.demo.Controllers;

import com.example.demo.DTOMappers.ScoreMapper;
import com.example.demo.DTOs.ScoreAvgDTO;
import com.example.demo.DTOs.ScoreCountDTO;
import com.example.demo.DTOs.ScoreDTO;
import com.example.demo.Entities.Score;
import com.example.demo.Services.ScoreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200/", allowedHeaders = "*")
@RequestMapping("/scores")
public class ScoreController {

    private ScoreService scoreService;
    private ScoreMapper scoreMapper;

    public ScoreController(ScoreService scoreService, ScoreMapper scoreMapper) {
        this.scoreService = scoreService;
        this.scoreMapper = scoreMapper;
    }

    @GetMapping("/game/{gameId}")
    public ResponseEntity<List<ScoreDTO>> getScoresByGameId(@PathVariable Integer gameId) {
        return ResponseEntity.ok(scoreMapper.toScoreDTOs(scoreService.getScoresByGameId(gameId)));
    }

    @GetMapping("/topAverage")
    public ResponseEntity<List<ScoreAvgDTO>> getAveargeScore() {
        return ResponseEntity.ok(scoreService.topAverageScores());
    }

    @GetMapping("/count")
    public ResponseEntity<List<ScoreCountDTO>> getCountScores() {
        return ResponseEntity.ok(scoreService.countScores());
    }

    @GetMapping()
    public ResponseEntity<List<ScoreDTO>> getScores() {
        return ResponseEntity.ok(scoreMapper.toScoreDTOs(scoreService.findAll()));
    }

    @GetMapping("/{scoreId}")
    ResponseEntity<ScoreDTO> getScore(@PathVariable Integer scoreId) {
        Optional<Score> score = scoreService.findById(scoreId);

        return score.map(score1 ->
                ResponseEntity.status(HttpStatus.OK).body(scoreMapper.toScoreDTO(score1)))
                .orElseGet(() ->
                        ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @PostMapping()
    ResponseEntity<ScoreDTO> addScore(@RequestBody ScoreDTO scoreDTO) {
        if (scoreService.save(scoreMapper.toScore(scoreDTO))) {
            return ResponseEntity.status(HttpStatus.CREATED).body(scoreDTO);
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(scoreDTO);
        }
    }

    //not used
    @PutMapping("/{scoreId}")
    ResponseEntity<ScoreDTO> updateScore(@PathVariable Integer scoreId, @RequestBody ScoreDTO scoreDTO) {
        if (scoreService.findById(scoreId).isPresent()) {
            scoreService.save(scoreMapper.toScore(scoreDTO));
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(scoreDTO);
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(scoreDTO);
        }
    }

    @DeleteMapping("/{scoreId}")
    ResponseEntity deleteScore(@PathVariable Integer scoreId) {
        scoreService.delete(scoreId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
