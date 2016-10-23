package com.vanhack.adapter.http.goal;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateGoalRequest {

	private String goalName;
	private BigDecimal value;
	private BigDecimal monthlyCost;
	private Integer months;

	@NotNull(message = "email is required (acting like a session key to keep it simple).")
	private String email;

	@JsonCreator
	public UpdateGoalRequest(@JsonProperty("email") String email, @JsonProperty("name") String goalName,
	  @JsonProperty("value") BigDecimal value, @JsonProperty("monthlyCost") BigDecimal monthlyCost, @JsonProperty("months") Integer months) {
		this.email = email; // fake session key
		this.goalName = goalName;
		this.value = value;
		this.monthlyCost = monthlyCost;
		this.months = months;
	}

	public String getEmail() {
		return email; // fake session key
	}

	public String getGoalName() {
		return goalName;
	}

	public BigDecimal getValue() {
		return value;
	}

	public BigDecimal getMonthlyCost() {
		return monthlyCost;
	}

	public Integer getMonths() {
		return months;
	}

}
