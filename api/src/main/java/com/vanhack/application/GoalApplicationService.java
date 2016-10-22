package com.vanhack.application;

import com.vanhack.application.dto.GoalDto;
import com.vanhack.domain.model.goal.Goal;
import com.vanhack.domain.model.goal.GoalService;
import com.vanhack.domain.model.user.User;
import com.vanhack.domain.model.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDate;

public class GoalApplicationService {

    private final static Logger log = LoggerFactory.getLogger(GoalApplicationService.class);

    @Autowired
    private GoalService goalService;

    @Autowired
    private UserService userService;

    public GoalDto create(String name, BigDecimal got, BigDecimal goal, LocalDate startDate, LocalDate goalDate, String userEmail) {
        User user = userService.findByEmail(userEmail);

        Goal goalEntity = new Goal(name, got, goal, startDate, goalDate, user);

        goalService.create(goalEntity);
        log.info("Created goal with id {}.", goalEntity.getId());

        return GoalDto.fromGoal(goalEntity);
    }
}
