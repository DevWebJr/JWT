package io.jwt.backend;

import io.jwt.backend.model.Role;
import io.jwt.backend.model.User;
import io.jwt.backend.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class JwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtApplication.class, args);
	}

	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null, "Tony Stark", "Ironman", "tony", new ArrayList<>()));
			userService.saveUser(new User(null, "Bruce Banner", "Hulk", "bruce", new ArrayList<>()));
			userService.saveUser(new User(null, "Peter Parker", "Spiderman", "peter", new ArrayList<>()));
			userService.saveUser(new User(null, "Steve Rogers", "Captain", "steve", new ArrayList<>()));

			userService.addRoleToUser("Ironman", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("Hulk", "ROLE_MANAGER");
			userService.addRoleToUser("Hulk", "ROLE_USER");
			userService.addRoleToUser("Spiderman", "ROLE_USER");
			userService.addRoleToUser("Captain", "ROLE_ADMIN");
		};
	}

}

