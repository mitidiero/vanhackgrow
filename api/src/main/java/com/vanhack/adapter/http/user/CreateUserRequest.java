package com.vanhack.adapter.http.user;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class CreateUserRequest {

    @NotNull(message = "User name is required.")
    private String name;
    @NotNull(message = "User email is required.")
    private String email;
    private BigDecimal total;

    @JsonCreator
    public CreateUserRequest(
            @JsonProperty("name") String name,
            @JsonProperty("email") String email,
            @JsonProperty("total") BigDecimal total) {
        this.name = name;
        this.email = email;
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public BigDecimal getTotal() {
        return total;
    }
}
