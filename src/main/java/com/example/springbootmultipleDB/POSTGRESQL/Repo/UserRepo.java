package com.example.springbootmultipleDB.POSTGRESQL.Repo;

import com.example.springbootmultipleDB.POSTGRESQL.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserModel, Integer> {

}
