package com.example.demo;

import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
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

    @PostMapping("/games")
    void addGames(@RequestBody BoardGame boardGame){
        boardGameRepo.save(boardGame);
    }
}
