package com.example.springbootmultipleDB.SQL.Repo;

import com.example.springbootmultipleDB.SQL.Model.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<CustomerModel,Integer> {

    CustomerModel findByName(String name);
}
