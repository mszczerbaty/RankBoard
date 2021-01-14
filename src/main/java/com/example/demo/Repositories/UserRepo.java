package com.example.demo.Repositories;

import com.example.demo.Entities.User;
import org.springframework.data.repository.CrudRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface UserRepo extends CrudRepository<User,Integer>{
    Optional<User> findByUsername(String username);
}
