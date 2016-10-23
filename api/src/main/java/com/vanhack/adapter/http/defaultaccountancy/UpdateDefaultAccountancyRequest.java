package com.vanhack.adapter.http.defaultaccountancy;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class UpdateDefaultAccountancyRequest {

    @NotNull(message = "Default Accountancy name is required.")
    private String name;
    @NotNull(message = "Default Accountancy value is required.")
    private BigDecimal value;

    @JsonCreator
    public UpdateDefaultAccountancyRequest(
            @JsonProperty("name") String name,
            @JsonProperty("value") BigDecimal value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getValue() {
        return value;
    }
}
