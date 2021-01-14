package com.example.demo.Services;

import com.example.demo.Entities.Author;
import com.example.demo.Entities.BoardGame;
import com.example.demo.Repositories.AuthorRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    AuthorRepo authorRepo;

    public AuthorService(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }

    public void save(@RequestBody Author author){
        authorRepo.save(author);
    }

    public List<Author> findAll() {
        return (List<Author>) authorRepo.findAll();
    }

    public Optional<Author> findById(@PathVariable int authorId) {
        return authorRepo.findById(authorId);
    }

    public Author update(@RequestBody Author author){
        return authorRepo.save(author);
    }

    public void delete(@PathVariable int authorId){
        authorRepo.deleteById(authorId);
    }

    public List<Author> findByGameId(@PathVariable int gameId) {
        return  authorRepo.findByGameId(gameId);
    }
}
