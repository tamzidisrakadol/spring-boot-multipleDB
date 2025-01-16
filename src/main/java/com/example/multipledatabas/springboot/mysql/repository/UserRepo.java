package com.example.multipledatabas.springboot.mysql.repository;

import com.example.multipledatabas.springboot.mysql.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {

}
