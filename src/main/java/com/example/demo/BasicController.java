package com.example.demo;

import net.bytebuddy.asm.Advice;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BasicController {
    private final BoardGameRepo boardGameRepo;

    BasicController(BoardGameRepo boardGameRepo) {
        this.boardGameRepo = boardGameRepo;
    }

    @GetMapping("/games")
    public List<BoardGame> getBoardGames() {
        return (List<BoardGame>) boardGameRepo.findAll();
    }

    @PostMapping("/games")
    void addGames(@RequestBody BoardGame boardGame){
        boardGameRepo.save(boardGame);
    }
}
