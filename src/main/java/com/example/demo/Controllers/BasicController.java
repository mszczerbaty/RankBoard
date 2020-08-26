package com.example.demo.Controllers;

import com.example.demo.Entities.Author;
import com.example.demo.Entities.BoardGame;
import com.example.demo.Entities.Extension;
import com.example.demo.Entities.Score;
import com.example.demo.Repositories.AuthorRepo;
import com.example.demo.Repositories.BoardGameRepo;
import com.example.demo.Repositories.ExtensionRepo;
import com.example.demo.Repositories.ScoreRepo;
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
    private final ExtensionRepo extensionRepo;
    private final ScoreRepo scoreRepo;

    @Autowired
    public BasicController(BoardGameRepo boardGameRepo, AuthorRepo authorRepo, ExtensionRepo extensionRepo, ScoreRepo scoreRepo) {
        this.boardGameRepo = boardGameRepo;
        this.authorRepo = authorRepo;
        this.extensionRepo = extensionRepo;
        this.scoreRepo = scoreRepo;
    }

    //BoardGame
    @PostMapping("/games")
    void addGame(@RequestBody BoardGame boardGame){
        boardGameRepo.save(boardGame);
    }

    @GetMapping("/games")
    public List<BoardGame> getBoardGames() {
        return (List<BoardGame>) boardGameRepo.findAll();
    }

    @GetMapping("/games/{gameId}")
    public Optional<BoardGame> getBoardGame(@PathVariable int gameId) {
        return boardGameRepo.findById(gameId);
    }

    @PutMapping("/games/{gameId}")
    public BoardGame updateBoardGame(@RequestBody BoardGame boardGame){
        return boardGameRepo.save(boardGame);
    }

    @DeleteMapping("/games/{gameId}")
    public void deleteGame(@PathVariable int gameId){
        boardGameRepo.deleteById(gameId);
    }

    //Author
    @PostMapping("/authors")
    void addAuthor(@RequestBody Author author){
        authorRepo.save(author);
    }

    @GetMapping("/authors")
    public List<Author> getAuthors(){
        return (List<Author>) authorRepo.findAll();
    }

    @GetMapping("/authors/{authorId}")
    public Optional<Author> getAuthor(@PathVariable int authorId) {
        return authorRepo.findById(authorId);
    }

    @PutMapping("/authors/{authorId}") //creates connection between boardgame and author
    void updateAuthor(@RequestBody Author author){
        authorRepo.save(author);
    }

    @DeleteMapping("/authors/{authorId}")
    public void deleteAuthor(@PathVariable int authorId){
        authorRepo.deleteById(authorId);
    }

    //Extension
    @PostMapping("/extensions")
    void addExtension(@RequestBody Extension extension){
        extensionRepo.save(extension);
    }

    @GetMapping("/extensions")
    public List<Extension> getExtensions(){
        return (List<Extension>) extensionRepo.findAll();
    }

    @GetMapping("/extensions/{extensionId}")
    public Optional<Extension> getExtension(@PathVariable int extensionId) {
        return extensionRepo.findById(extensionId);
    }

    @PutMapping("/extensions/{extensionId}")
    void updateExtension(@RequestBody Extension extension){
        extensionRepo.save(extension);
    }

    @DeleteMapping("/extensions/{extensionId}")
    public void deleteExtension(@PathVariable int extensionId){
        extensionRepo.deleteById(extensionId);
    }

    //Score
    @PostMapping("/scores")
    void addScore(@RequestBody Score score){
        scoreRepo.save(score);
    }

    @GetMapping("/scores")
    public List<Score> getScores() {
        return (List<Score>) scoreRepo.findAll();
    }

    @PutMapping("/scores/{scoreId}")
    void updateScore(@RequestBody Score score){
        scoreRepo.save(score);
    }

    @DeleteMapping("/scores/{scoreId}")
    public void deleteScore(@PathVariable int scoreId){
        scoreRepo.deleteById(scoreId);
    }
   }
