package com.example.demo.Services;


import com.example.demo.DTOs.UserDTO;
import com.example.demo.Entities.Role;
import com.example.demo.Entities.User;
import com.example.demo.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.example.demo.Entities.Role.ROLE_ADMIN;
import static com.example.demo.Entities.Role.ROLE_USER;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        System.out.println(s);
        Optional<User> username = userRepo.findByUsername(s);
        if (username.isPresent()){
            return username.get();
        } else {
            throw new UsernameNotFoundException(String.format("Username " + s + " not found"));
        }
    }

    //if admin registers user grant him admin role
    public void save(UserDTO registration) {
        User user = new User();
        user.setUsername(registration.getUsername());

        if((SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN")))){//ROLE_ADMIN OR ADMIN?
            user.setRoles(Arrays.asList(ROLE_ADMIN, ROLE_USER));
        } else {
            user.setRoles(Arrays.asList(Role.ROLE_USER));
        }
        user.setPassword(passwordEncoder.encode(registration.getPassword()));
        userRepo.save(user);
    }
}
