package com.example.demo.Services;

import com.example.demo.Entities.Author;
import com.example.demo.Entities.BoardGame;
import com.example.demo.Repositories.AuthorRepo;
import com.example.demo.Repositories.BoardGameRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class BoardGameService {

    BoardGameRepo boardGameRepo;

    public BoardGameService(BoardGameRepo boardGameRepo) {
        this.boardGameRepo = boardGameRepo;
    }

    public void save(@RequestBody BoardGame boardGame){
        boardGameRepo.save(boardGame);
    }

    public List<BoardGame> findAll() {
        return (List<BoardGame>) boardGameRepo.findAll();
    }

    public Optional<BoardGame> findById(@PathVariable int gameId) {
        return boardGameRepo.findById(gameId);
    }

    public BoardGame update(@RequestBody BoardGame boardGame){
        return boardGameRepo.save(boardGame);
    }

    public void delete(@PathVariable int gameId){
        boardGameRepo.deleteById(gameId);
    }

    public List<BoardGame> findByAuthorId(@PathVariable int authorId) {
        return  boardGameRepo.findByAuthorId(authorId);
    }
}
