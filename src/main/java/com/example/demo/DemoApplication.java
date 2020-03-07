package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		ApplicationContext apl=SpringApplication.run(DemoApplication.class, args);

		UserService userService = apl.getBean(UserService.class);
		userService.createUser("firstName1", "lastName1", "email1@example.com");
		userService.createUser("firstName2", "lastName2", "email1@example.com2");
		userService.createUser("firstNam12", "lastName2", "email1@example.com2");
		userService.createUser("firstNam12", "lastName", "email1@exampm2");

		userService.createUser("firstNamea", "lastName2", "email1@example.coma");

		{
			List<UserEntity> users=userService.findAllUsers();
			for (UserEntity ue : users)
				System.out.println(ue);

		}
		{
			List<UserEntity> users = userService.findBySurname("lastName2");
			for (UserEntity ue : users)
				System.out.println(ue);
		}

		System.out.println(userService.contains("firstNam12"));
	}


}
