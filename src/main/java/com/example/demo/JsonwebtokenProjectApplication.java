package com.example.demo;

import com.example.demo.domain.Role;
import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
@EnableWebSecurity
public class JsonwebtokenProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(JsonwebtokenProjectApplication.class, args);
	}
	@Bean
	public BCryptPasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService){
		return args -> {
			userService.saveRole(new Role(null,"ROLE_USER"));
			userService.saveRole(new Role(null,"ROLE_MANAGER"));
			userService.saveRole(new Role(null,"ROLE_ADMIN"));
			userService.saveRole(new Role(null,"ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null,"Gasmi Nadia","nadia","1234",new ArrayList<>()));
			userService.saveUser(new User(null,"Gasmi Badr","badr","1111",new ArrayList<>()));
			userService.saveUser(new User(null,"Gasmi Nadia","rabha","2222",new ArrayList<>()));
			userService.saveUser(new User(null,"Gasmi Nadia","israe","0000",new ArrayList<>()));

			userService.addRoleToUser("nadia","ROLE_USER");
			userService.addRoleToUser("nadia","ROLE_ADMIN");
			userService.addRoleToUser("badr","ROLE_USER");
			userService.addRoleToUser("rabha","ROLE_SUPER_ADMIN");
			userService.addRoleToUser("israe","ROLE_MANAGER");
			userService.addRoleToUser("nadia","ROLE_SUPER_ADMIN");
		};
	}
}
