package com.vanhack.application.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.vanhack.domain.model.goal.Goal;

public class GoalDto {

	private String id;
	private String name;
	private Integer months;
	private BigDecimal value;
	private BigDecimal monthlyCost;

	@JsonCreator
	public GoalDto(@JsonProperty("id") String id, @JsonProperty("name") String name, @JsonProperty("value") BigDecimal value,
	  @JsonProperty("months") Integer months, @JsonProperty("monthlyCost") BigDecimal monthlyCost) {
		this.id = id;
		this.name = name;
		this.value = value;
		this.months = months;
		this.monthlyCost = monthlyCost;
	}

	public Integer getMonths() {
		return months;
	}

	public BigDecimal getValue() {
		return value;
	}

	public BigDecimal getMonthlyCost() {
		return monthlyCost;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static GoalDto fromGoal(Goal goal) {
		return new GoalDto(goal.getId().toString(), goal.getName(), goal.getValue(), goal.getMonths(), goal.getMonthlyCost());
	}
}
