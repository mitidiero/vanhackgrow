package com.vanhack;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.vanhack.domain.model.goal.Goal;
import com.vanhack.domain.model.goal.GoalRepository;
import com.vanhack.domain.model.user.User;
import com.vanhack.domain.model.user.UserRepository;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner demo(UserRepository userRepository, GoalRepository goalRepository) {
		return (args) -> {
			userRepository.save(new User("José", "jose@example.com", null));

			User user = userRepository.findOne(1L);
			goalRepository.save(new Goal("Trip to USA", 10, new BigDecimal(2000), new BigDecimal(100), user));
			goalRepository.save(new Goal("New House", 360, new BigDecimal(500000), new BigDecimal(2000), user));

			log.info("User goals found with findByUser");
			List<Goal> userGoals = goalRepository.findByUser(user);
			userGoals.stream().forEach(goal -> log.info(goal.toString()));
		};
	}
}
