package com.vanhack.adapter.http.goal;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateGoalRequest {

	private String goalName;
	private BigDecimal gotAmount;
	private BigDecimal goalAmount;
	private LocalDate startDate;
	private LocalDate goalDate;

	@NotNull(message = "email is required (acting like a session key to keep it simple).")
	private String email;

	@JsonCreator
	public UpdateGoalRequest(@JsonProperty("email") String email, @JsonProperty("name") String goalName,
	  @JsonProperty("got$") BigDecimal got, @JsonProperty("goal$") BigDecimal goal, @JsonProperty("startDate") LocalDate startDate,
	  @JsonProperty("goalDate") LocalDate goalDate) {
		this.email = email; // fake session key
		this.goalName = goalName;
		this.gotAmount = got;
		this.goalAmount = goal;
		this.startDate = startDate;
		this.goalDate = goalDate;
	}

	public String getEmail() {
		return email; // fake session key
	}

	public String getGoalName() {
		return goalName;
	}

	public BigDecimal getGotAmount() {
		return gotAmount;
	}

	public BigDecimal getGoalAmount() {
		return goalAmount;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public LocalDate getGoalDate() {
		return goalDate;
	}
}
