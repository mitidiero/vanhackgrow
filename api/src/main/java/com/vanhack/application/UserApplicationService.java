package com.vanhack.application;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vanhack.adapter.http.user.UserSession;
import com.vanhack.application.dto.UserDto;
import com.vanhack.domain.model.user.User;
import com.vanhack.domain.model.user.UserService;

@Service
public class UserApplicationService {

	private final static Logger log = LoggerFactory.getLogger(UserApplicationService.class);

	@Autowired
	private UserService userService;

	@Autowired
	private UserSession session;

	public UserDto create(String name, String email, BigDecimal total) {
		User user = new User(name, email, total);

		userService.create(user);
		log.info("Created user with id {}.", user.getId());

		return UserDto.fromUser(user);
	}

	public UserDto update(Long userId, String name, BigDecimal total) {
		User user = userService.update(userId, name, total);

		log.info("Update user {}.", user.getId());

		return UserDto.fromUser(user);
	}

	public UserDto signIn(String email) {
		User user = userService.findByEmail(email);
		session.setEmail(email); // logged in
		return UserDto.fromUser(user);
	}
}
