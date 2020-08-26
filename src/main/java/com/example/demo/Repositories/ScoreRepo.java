package com.example.demo.Repositories;

import com.example.demo.Entities.Score;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreRepo extends CrudRepository<Score, Integer> {
}
