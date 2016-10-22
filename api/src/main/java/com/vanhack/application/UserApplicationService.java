package com.vanhack.application;

import com.vanhack.application.dto.UserDto;
import com.vanhack.domain.model.user.User;
import com.vanhack.domain.model.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UserApplicationService {

    private final static Logger log = LoggerFactory.getLogger(UserApplicationService.class);

    @Autowired
    private UserService userService;

    public UserDto create(String name, String email, String password, BigDecimal total) {
        User user = new User(name, email, password, total);

        userService.create(user);
        log.info("Created user with id {}.", user.getId());

        return UserDto.fromUser(user);
    }

    public UserDto update(Long userId, String name, BigDecimal total) {
        User user = userService.update(userId, name, total);

        log.info("Update user {}.", user.getId());

        return UserDto.fromUser(user);
    }
}
