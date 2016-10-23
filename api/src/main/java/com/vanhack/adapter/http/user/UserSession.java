package com.vanhack.adapter.http.user;

import org.springframework.web.context.annotation.SessionScope;

@SessionScope
public class UserSession {

	/**
	 * if not null, the user is logged.
	 */
	private String email;

	public UserSession() {

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
