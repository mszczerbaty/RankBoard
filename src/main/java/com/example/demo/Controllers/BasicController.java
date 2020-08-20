package com.example.demo.Controllers;

import com.example.demo.Entities.Author;
import com.example.demo.Entities.BoardGame;
import com.example.demo.Entities.Extenstion;
import com.example.demo.Repositories.AuthorRepo;
import com.example.demo.Repositories.BoardGameRepo;
import com.example.demo.Repositories.ExtenstionRepo;
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
    private final ExtenstionRepo extenstionRepo;

    @Autowired
    public BasicController(BoardGameRepo boardGameRepo, AuthorRepo authorRepo, ExtenstionRepo extenstionRepo) {
        this.boardGameRepo = boardGameRepo;
        this.authorRepo = authorRepo;
        this.extenstionRepo = extenstionRepo;
    }

    @GetMapping("/extensions")
    public List<Extenstion> getExtenstions(){
        return (List<Extenstion>) extenstionRepo.findAll();
    }

    @GetMapping("/authors")
    public List<Author> getAuthors(){
        return (List<Author>) authorRepo.findAll();
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

    @PostMapping("/authors")
    void addAuthor(@RequestBody Author author){
        authorRepo.save(author);
    }

    @PutMapping("/games")
    void editGame(@RequestBody BoardGame boardGame){
        boardGameRepo.save(boardGame);
    }
}
