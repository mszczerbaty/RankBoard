package com.example.demo.Controllers;

import com.example.demo.DTOs.UserDTO;
import com.example.demo.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin(origins = "http://localhost:4200/", allowedHeaders = "*")
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping
    @ResponseBody
    public Principal user(Principal user) {
        System.out.println("user logged "+ user);
        return user;
    }

    @PostMapping("/register")
    @ResponseBody
    ResponseEntity<UserDTO> register(@RequestBody UserDTO userDTO) {
        userService.save(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(userDTO);
    }

}
