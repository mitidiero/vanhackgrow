package com.vanhack.adapter.http.user;

import com.vanhack.application.UserApplicationService;
import com.vanhack.application.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserHttpAdapter {

	@Autowired
	private UserApplicationService userApplicationService;

	@RequestMapping(value = "/users", method = { RequestMethod.POST })
	@ResponseStatus(HttpStatus.CREATED)
	public UserDto create(@Valid @RequestBody final CreateUserRequest request) {
		return userApplicationService.create(request.getName(), request.getEmail(), request.getTotal());
	}

	@RequestMapping(value = "/users/{userId}", method = { RequestMethod.PUT })
	@ResponseStatus(HttpStatus.CREATED)
	public UserDto update(@PathVariable String userId, @Valid @RequestBody UpdateUserRequest request) {
		return userApplicationService.update(Long.valueOf(userId), request.getName(), request.getTotal());
	}

	@RequestMapping(value = "/signin", method = { RequestMethod.POST })
	public UserDto signIn(@Valid @RequestBody SignInRequest request) {
		return userApplicationService.signIn(request.getEmail());
	}
}
