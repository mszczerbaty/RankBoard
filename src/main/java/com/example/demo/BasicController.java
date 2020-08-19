package com.example.demo;

import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/RankBoard")
public class BasicController {

    private final BoardGameRepo boardGameRepo;

    @Autowired
    BasicController(BoardGameRepo boardGameRepo) {
        this.boardGameRepo = boardGameRepo;
    }

    @GetMapping("/games")
    public List<BoardGame> getBoardGames() {
        return (List<BoardGame>) boardGameRepo.findAll();
    }

    @GetMapping("/games/{gameId}")
    public Optional<BoardGame> getBoardGame(@PathVariable int gameId) {
        return boardGameRepo.findById(gameId);
    }

    @DeleteMapping("/games/{gameId}")
    public void deleteGame(@PathVariable int gameId){
        boardGameRepo.deleteById(gameId);
    }

    @PostMapping("/games")
    void addGame(@RequestBody BoardGame boardGame){
        boardGameRepo.save(boardGame);
    }

    @PutMapping("/games")
    void editGame(@RequestBody BoardGame boardGame){
        boardGameRepo.save(boardGame);
    }
}
