package com.vanhack.adapter.http.defaultaccountancy;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class CreateDefaultAccountancyRequest {

    @NotNull(message = "Default Accountancy name is required.")
    private String name;
    @NotNull(message = "Default Accountancy value is required.")
    private BigDecimal value;
    @NotNull(message = "User Id is required.")
    private Long userId;

    @JsonCreator
    public CreateDefaultAccountancyRequest(
            @JsonProperty("name") String name,
            @JsonProperty("value") BigDecimal value,
            @JsonProperty("userId") Long userId) {
        this.name = name;
        this.value = value;
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getValue() {
        return value;
    }

    public Long getUserId() {
        return userId;
    }
}
