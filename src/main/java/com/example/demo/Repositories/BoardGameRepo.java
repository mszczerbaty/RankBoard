package com.example.demo.Repositories;

import com.example.demo.Entities.BoardGame;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardGameRepo extends CrudRepository<BoardGame, Integer> {

    @Query("SELECT b FROM BoardGame b join b.authors ba WHERE ba.id=:authorId")
    List<BoardGame> findByAuthorId(@Param("authorId") int authorId);

    @Query("SELECT CASE WHEN COUNT(*) > 0 THEN TRUE ELSE FALSE END FROM BoardGame b WHERE b.boardgamename=:boardgamename")
    boolean isBoardgameAdded(@Param("boardgamename") String boardgamename);
}
