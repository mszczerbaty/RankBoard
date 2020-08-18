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
    private final AuthorRepo authorRepo;

    @Autowired
    BasicController(BoardGameRepo boardGameRepo, AuthorRepo authorRepo) {
        this.boardGameRepo = boardGameRepo;
        this.authorRepo = authorRepo;
    }

    @GetMapping("/games")
    public List<BoardGame> getBoardGames() {
        return (List<BoardGame>) boardGameRepo.findAll();
    }

    @GetMapping("/games/{gameId}")
    public Optional<BoardGame> getBoardGame(@PathVariable Long gameId) {
        return boardGameRepo.findById(gameId);
    }

    @DeleteMapping("/games/{gameId}")
    public void deleteGame(@PathVariable Long gameId){
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
