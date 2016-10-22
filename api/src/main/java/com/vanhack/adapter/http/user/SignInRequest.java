package com.vanhack.adapter.http.user;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class SignInRequest {

    @NotNull(message = "User email is required.")
    private String email;

    @JsonCreator
    public SignInRequest(
            @JsonProperty("email") String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
