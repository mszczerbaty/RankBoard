package com.example.demo.Controllers;

import com.example.demo.DTOMappers.BoardGameMapper;
import com.example.demo.DTOs.AuthorDTO;
import com.example.demo.DTOs.BoardGameDTO;
import com.example.demo.Entities.Author;
import com.example.demo.Entities.BoardGame;
import com.example.demo.Services.BoardGameService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200/", allowedHeaders = "*")
@RequestMapping("/boardgames")
public class BoardGameController {

    private BoardGameService boardGameService;
    private BoardGameMapper boardGameMapper;

    public BoardGameController(BoardGameService boardGameService, BoardGameMapper boardGameMapper) {
        this.boardGameService = boardGameService;
        this.boardGameMapper = boardGameMapper;
    }

    @GetMapping()
    public ResponseEntity<List<BoardGameDTO>> getBoardGames() {
        return ResponseEntity.ok(boardGameMapper.toBoardGameDTOs(boardGameService.findAll()));
    }

    @GetMapping("/{boardGameId}")
    ResponseEntity<BoardGameDTO> getBoardGame(@PathVariable Integer boardGameId) {
        Optional<BoardGame> boardGame = boardGameService.findById(boardGameId);
        return boardGame.map(boardGame1 ->
                ResponseEntity.status(HttpStatus.OK).body(boardGameMapper.toBoardGameDTO(boardGame1)))
                .orElseGet(() ->
                        ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @GetMapping("/author/{authorId}")
    public ResponseEntity<List<BoardGameDTO>> getBoardgamesByAuthorId(@PathVariable int authorId) {
        return ResponseEntity.ok(boardGameMapper.toBoardGameDTOs(boardGameService.findByAuthorId(authorId)));
    }

    @PostMapping()
    ResponseEntity<BoardGameDTO> addBoardGame(@RequestBody BoardGameDTO boardGameDTO) {
        if (boardGameService.save(boardGameMapper.toBoardGame(boardGameDTO))) {
            return ResponseEntity.status(HttpStatus.CREATED).body(boardGameDTO);
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(boardGameDTO);
        }
    }

    @PutMapping("/{boardGameId}")
    ResponseEntity<BoardGameDTO> updateBoardGame(@PathVariable Integer boardGameId, @RequestBody BoardGameDTO boardGameDTO) {
        if (boardGameService.findById(boardGameId).isPresent() && boardGameService.save(boardGameMapper.toBoardGame(boardGameDTO))) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(boardGameDTO);
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(boardGameDTO);
        }
    }

    @DeleteMapping("/{boardGameId}")
    ResponseEntity deleteBoardGame(@PathVariable Integer boardGameId) {
        boardGameService.delete(boardGameId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
