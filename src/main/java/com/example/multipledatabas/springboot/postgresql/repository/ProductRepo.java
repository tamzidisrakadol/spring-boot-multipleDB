package com.example.multipledatabas.springboot.postgresql.repository;

import com.example.multipledatabas.springboot.postgresql.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {

}
