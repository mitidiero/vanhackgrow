package com.vanhack.domain.model.periodicalyaccountancy;

import com.vanhack.domain.model.defaultaccountancy.DefaultAccountancy;
import com.vanhack.domain.model.goal.Goal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;

public class PeriodicalAccountancy {

    private Long id;
    private BigDecimal value;
    private LocalDate entryDate;
    private DefaultAccountancy defaultAccountancy;
    private Goal goal;

    public PeriodicalAccountancy(BigDecimal value, LocalDate entryDate, DefaultAccountancy defaultAccountancy, Goal goal) {
        this.value = value;
        this.entryDate = entryDate;
        this.defaultAccountancy = defaultAccountancy;
        this.goal = goal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }

    public DefaultAccountancy getDefaultAccountancy() {
        return defaultAccountancy;
    }

    public void setDefaultAccountancy(DefaultAccountancy defaultAccountancy) {
        this.defaultAccountancy = defaultAccountancy;
    }

    public Goal getGoal() {
        return goal;
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }
}
