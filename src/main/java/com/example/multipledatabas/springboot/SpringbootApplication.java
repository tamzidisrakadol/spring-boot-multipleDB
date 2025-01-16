package com.example.multipledatabas.springboot;

import com.example.multipledatabas.springboot.mysql.Entity.User;
import com.example.multipledatabas.springboot.mysql.repository.UserRepo;
import com.example.multipledatabas.springboot.postgresql.Entity.Product;
import com.example.multipledatabas.springboot.postgresql.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}

}
