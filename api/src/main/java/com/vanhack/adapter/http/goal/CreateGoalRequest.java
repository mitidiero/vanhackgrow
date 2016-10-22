package com.vanhack.adapter.http.goal;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateGoalRequest {

	@NotNull(message = "Goal NAME is required.")
	private String goalName;

	@NotNull(message = "Got VALUE is required.")
	private BigDecimal gotAmount;

	@NotNull(message = "Goal VALUE is required.")
	private BigDecimal goalAmount;

	@NotNull(message = "Start DATE is required.")
	private LocalDate startDate;

	@NotNull(message = "Goal DATE is required.")
	private LocalDate goalDate;

	@NotNull(message = "email is required (acting like a session key to keep it simple).")
	private String email;

	@JsonCreator
	public CreateGoalRequest(@JsonProperty("name") String goalName, @JsonProperty("got$") BigDecimal gotAmount,
	  @JsonProperty("goal$") BigDecimal goalAmount, @JsonProperty("startDate") LocalDate startDate,
	  @JsonProperty("goalDate") LocalDate goalDate) {
		this.goalName = goalName;
		this.gotAmount = gotAmount;
		this.goalAmount = goalAmount;
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
