package com.example.multipledatabas.springboot.mysql.Controller;

import com.example.multipledatabas.springboot.mysql.Entity.User;
import com.example.multipledatabas.springboot.mysql.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepo userRepo;


    @PostMapping("/saveUser")
    private void saveUser(){
        User user = User.builder().name("Azmol").address("Jhinaidah").build();
        userRepo.save(user);
        System.out.println("User data is saved");
    }

}
