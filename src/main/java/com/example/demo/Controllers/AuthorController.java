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

@RestController
@CrossOrigin(origins = "http://localhost:4200/", allowedHeaders = "*")
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;
    private AuthorMapper authorMapper;

    public AuthorController(AuthorService authorService, AuthorMapper authorMapper) {
        this.authorService = authorService;
        this.authorMapper = authorMapper;
    }

    //Author
    @GetMapping("")
    public ResponseEntity<List<AuthorDTO>> getAuthors(){
        System.out.println("wykonuje get authors");
        return ResponseEntity.ok(authorMapper.toAuthorDTOs(authorService.findAll()));
    }

    @GetMapping("/game/{gameId}")
    public ResponseEntity<List<AuthorDTO>> getAuthors(@PathVariable int gameId){
        return ResponseEntity.ok(authorMapper.toAuthorDTOs(authorService.findByGameId(gameId)));
    }

    @GetMapping("/{authorId}")
    ResponseEntity<AuthorDTO> getAuthor(@PathVariable int authorId){
        Optional<Author> author = authorService.findById(authorId);
        return ResponseEntity.ok(authorMapper.toAuthorDTO(author.get()));
    }

    @PostMapping()
    ResponseEntity<AuthorDTO> addAuthor(@RequestBody AuthorDTO authorDTO){
        Author author = authorMapper.toAuthor(authorDTO);
        authorService.save(author);
        return ResponseEntity.status(HttpStatus.CREATED).body(authorDTO);
    }

    @PutMapping("/{authorId}")
    ResponseEntity<AuthorDTO> updateAuthor(@PathVariable Integer authorId, @RequestBody AuthorDTO authorDTO){
        authorService.findById(authorId).map(author -> {
            author.setAuthorname(authorDTO.getAuthorname());
            author.setAuthorsurname(authorDTO.getAuthorsurname());
            author.setShortbio(authorDTO.getShortbio());
            author.setBoardgames(authorDTO.getBoardgames());
            authorService.save(author);
            System.out.println("wykonuje get authors");
            return true;
        }); //#1
        authorDTO.setId(authorId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(authorDTO);
    }

    @DeleteMapping("/{authorId}")
    ResponseEntity deleteAuthor(@PathVariable Integer authorId){
        authorService.delete(authorId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
