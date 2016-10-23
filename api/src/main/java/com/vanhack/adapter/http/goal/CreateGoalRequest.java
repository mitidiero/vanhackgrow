package com.vanhack.adapter.http.goal;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

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

	@NotNull(message = "User Id is required.")
	private Long userId;

	@JsonCreator
	public CreateGoalRequest(
			@JsonProperty("name") String goalName,
			@JsonProperty("got$") BigDecimal gotAmount,
	  		@JsonProperty("goal$") BigDecimal goalAmount,
			@JsonProperty("startDate") LocalDate startDate,
	  		@JsonProperty("goalDate") LocalDate goalDate,
			@JsonProperty("userId") Long userId) {
		this.goalName = goalName;
		this.gotAmount = gotAmount;
		this.goalAmount = goalAmount;
		this.startDate = startDate;
		this.goalDate = goalDate;
		this.userId = userId;
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

	public Long getUserId() {
		return userId;
	}
}
