package com.example.demo.Repositories;

import com.example.demo.Entities.Extenstion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExtenstionRepo extends CrudRepository<Extenstion, Integer> {
}
