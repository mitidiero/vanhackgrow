package com.vanhack.adapter.http.user;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class UpdateUserRequest {

    @NotNull(message = "User name is required.")
    private String name;
    private BigDecimal total;

    @JsonCreator
    public UpdateUserRequest(
            @JsonProperty("name") String name,
            @JsonProperty("total") BigDecimal total) {
        this.name = name;
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getTotal() {
        return total;
    }
}
