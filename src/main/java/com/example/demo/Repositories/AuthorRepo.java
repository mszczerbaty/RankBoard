package com.example.demo.Repositories;

import com.example.demo.Entities.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepo extends CrudRepository<Author,Integer> {
}
