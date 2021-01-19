package com.example.demo.Repositories;

import com.example.demo.Entities.Author;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepo extends CrudRepository<Author,Integer> {

    @Query("SELECT a FROM Author a join a.boardgames ba WHERE ba.id=:gameId")
    List<Author> findByGameId(@Param("gameId")int gameId);

    @Query("SELECT CASE WHEN COUNT(*) > 0 THEN TRUE ELSE FALSE END FROM Author a WHERE a.authorname=:authorname AND a.authorsurname=:authorsurname")
    boolean isAuthorAdded(@Param("authorname")String authorname, @Param("authorsurname")String authorsurname);
}
