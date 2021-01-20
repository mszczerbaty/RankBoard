package com.example.demo.Repositories;

import com.example.demo.Entities.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepo extends CrudRepository<Category, Integer> {

    @Query("SELECT c FROM Category c join c.boardgames cb WHERE cb.id=:gameId")
    List<Category> findByGameId(@Param("gameId") int gameId);

    @Query("SELECT CASE WHEN COUNT(*) > 0 THEN TRUE ELSE FALSE END FROM Category c WHERE c.category=:category")
    boolean isCategoryAdded(@Param("category") String category);
}
