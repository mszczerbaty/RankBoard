package com.example.demo.Repositories;

import com.example.demo.Entities.Extension;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExtensionRepo extends CrudRepository<Extension, Integer> {
}
