package com.vanhack.application.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.vanhack.domain.model.goal.Goal;

import java.math.BigDecimal;
import java.time.LocalDate;

public class GoalDto {

    private String id;
    private String name;
    private BigDecimal got;
    private BigDecimal goal;
    private LocalDate startDate;
    private LocalDate goalDate;

    @JsonCreator
    public GoalDto(
            @JsonProperty("id") String id,
            @JsonProperty("name") String name,
            @JsonProperty("got") BigDecimal got,
            @JsonProperty("goal") BigDecimal goal,
            @JsonProperty("startDate") LocalDate startDate,
            @JsonProperty("goalDate") LocalDate goalDate) {
        this.id = id;
        this.name = name;
        this.got = got;
        this.goal = goal;
        this.startDate = startDate;
        this.goalDate = goalDate;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getGot() {
        return got;
    }

    public BigDecimal getGoal() {
        return goal;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getGoalDate() {
        return goalDate;
    }

    public static GoalDto fromGoal(Goal goal) {
        return new GoalDto(
                goal.getId().toString(),
                goal.getName(),
                goal.getGot(),
                goal.getGoal(),
                goal.getStartDate(),
                goal.getGoalDate()
        );
    }
}
