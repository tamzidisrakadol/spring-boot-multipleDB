package com.example.springbootmultipleDB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootMultipleDbApplication {

	public static void main(String[] args) {
	 SpringApplication.run(SpringBootMultipleDbApplication.class, args);
//		UserRepo userRepo = context.getBean(UserRepo.class);
//		CustomerRepo customerRepo = context.getBean(CustomerRepo.class);
//
//		UserModel userModel = new UserModel();
//		userModel.setContactInfo("tamz");
//		userModel.setFirstName("ISrak");
//
//		userRepo.save(userModel);
//
//
//		CustomerModel customerModel= new CustomerModel();
//		customerModel.setName("ADOL");
//		customerModel.setAddress("ZIllapara");
//		customerRepo.save(customerModel);
	}

}
