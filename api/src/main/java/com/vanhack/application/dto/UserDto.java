package com.vanhack.application.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.vanhack.domain.model.user.User;

import java.math.BigDecimal;

public class UserDto {

    private String id;
    private String name;
    private String email;
    private String password;
    private BigDecimal total;

    @JsonCreator
    public UserDto(
            @JsonProperty("id") String id,
            @JsonProperty("name") String name,
            @JsonProperty("email") String email,
            @JsonProperty("password") String password,
            @JsonProperty("total") BigDecimal total) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.total = total;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public static UserDto fromUser(User user) {
        return new UserDto(
                user.getId().toString(),
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                user.getTotal() != null ? user.getTotal() : null
        );
    }
}
