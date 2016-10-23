package com.vanhack.adapter.http.goal;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateGoalRequest {

	@NotNull(message = "Goal NAME is required.")
	private String goalName;

	@NotNull(message = "Got VALUE is required.")
	private BigDecimal value;

	@NotNull(message = "Goal monthlyCost is required.")
	private BigDecimal monthlyCost;

	@NotNull(message = "Number of months is required.")
	private Integer months;

	@NotNull(message = "User Id is required.")
	private Long userId;

	@JsonCreator
	public CreateGoalRequest(@JsonProperty("name") String goalName, @JsonProperty("value") BigDecimal value,
	  @JsonProperty("monthlyCost") BigDecimal monthlyCost, @JsonProperty("months") Integer months, @JsonProperty("userId") Long userId) {
		this.goalName = goalName;
		this.value = value;
		this.monthlyCost = monthlyCost;
		this.months = months;
		this.userId = userId;
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

	public Long getUserId() {
		return userId;
	}
}
