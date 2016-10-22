package com.vanhack.domain.model.periodicalyaccountancy;

import com.vanhack.domain.model.goal.Goal;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class PeriodicalAccountancy {

    private Long id;
    private BigDecimal value;
    private LocalDate entryDate;

    private Goal goal;
}
