package com.vanhack.application.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.vanhack.domain.model.defaultaccountancy.DefaultAccountancy;

import java.math.BigDecimal;

public class DefaultAccountancyDto {

    private String id;
    private String name;
    private BigDecimal value;

    @JsonCreator
    public DefaultAccountancyDto(
            @JsonProperty("id") String id,
            @JsonProperty("name") String name,
            @JsonProperty("value") BigDecimal value) {
        this.id = id;
        this.name = name;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getValue() {
        return value;
    }

    public static DefaultAccountancyDto fromDefaultAccountancy(DefaultAccountancy defaultAccountancy) {
        return new DefaultAccountancyDto(
                defaultAccountancy.getId().toString(),
                defaultAccountancy.getName(),
                defaultAccountancy.getValue()
        );
    }
}
