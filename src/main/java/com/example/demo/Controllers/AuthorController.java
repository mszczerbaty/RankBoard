package com.example.demo.Controllers;

import com.example.demo.DTOMappers.AuthorMapper;
import com.example.demo.DTOs.AuthorDTO;
import com.example.demo.Entities.Author;
import com.example.demo.Services.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@CrossOrigin(origins = "http://localhost:4200/", allowedHeaders = "*")
@RequestMapping("/authors")
public class AuthorController {

    private AuthorService authorService;
    private AuthorMapper authorMapper;

    public AuthorController(AuthorService authorService, AuthorMapper authorMapper) {
        this.authorService = authorService;
        this.authorMapper = authorMapper;
    }

    //Author
    @GetMapping()
    ResponseEntity<List<AuthorDTO>> getAuthors() {
        return ok(authorMapper.toAuthorDTOs(authorService.findAll()));
    }

    @GetMapping("/game/{gameId}")
    ResponseEntity<List<AuthorDTO>> getAuthors(@PathVariable int gameId) {
        return ok(authorMapper.toAuthorDTOs(authorService.findByGameId(gameId)));
    }

    @GetMapping("/{authorId}")
    ResponseEntity<AuthorDTO> getAuthor(@PathVariable int authorId) {
        Optional<Author> author = authorService.findById(authorId);
        return author.map(author1 ->
                ResponseEntity.status(HttpStatus.OK).body(authorMapper.toAuthorDTO(author1)))
                .orElseGet(() ->
                        ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @PostMapping()
    ResponseEntity<AuthorDTO> addAuthor(@RequestBody AuthorDTO authorDTO) {
        if (authorService.save(authorMapper.toAuthor(authorDTO))) {
            return ResponseEntity.status(HttpStatus.CREATED).body(authorDTO);
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(authorDTO);
        }
    }

    @PutMapping("/{authorId}")
    ResponseEntity<AuthorDTO> updateAuthor(@PathVariable Integer authorId, @RequestBody AuthorDTO authorDTO) {
        authorService.findById(authorId).map(author -> {
            author.setAuthorname(authorDTO.getAuthorname());
            author.setAuthorsurname(authorDTO.getAuthorsurname());
            author.setShortbio(authorDTO.getShortbio());
            author.setBoardgames(authorDTO.getBoardgames());
            return authorService.save(author);
        });
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(authorDTO);
    }

    @DeleteMapping("/{authorId}")
    ResponseEntity deleteAuthor(@PathVariable Integer authorId) {
        authorService.delete(authorId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
