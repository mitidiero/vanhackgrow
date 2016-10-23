package com.vanhack.application;

import com.vanhack.application.dto.GoalDto;
import com.vanhack.domain.model.goal.Goal;
import com.vanhack.domain.model.goal.GoalService;
import com.vanhack.domain.model.user.User;
import com.vanhack.domain.model.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GoalApplicationService {

	private final static Logger log = LoggerFactory.getLogger(GoalApplicationService.class);

	@Autowired
	private GoalService goalService;

	@Autowired
	private UserService userService;

	public GoalDto create(String name, BigDecimal got, BigDecimal goal, LocalDate startDate, LocalDate goalDate, Long userId) {
		User user = userService.findById(userId);
		Goal goalEntity = new Goal(name, got, goal, startDate, goalDate, user);
		goalService.create(goalEntity);
		log.info("Created goal with id {}.", goalEntity.getId());
		return GoalDto.fromGoal(goalEntity);
	}

	public GoalDto update(Long goalID, String goalName, BigDecimal gotAmount, BigDecimal goalAmount, LocalDate startDate, LocalDate goalDate) {
		Goal updated = goalService.update(goalID, goalName, gotAmount, goalAmount, startDate, goalDate);
		log.info("Updated goal with id {}.", updated.getId());
		return GoalDto.fromGoal(updated);
	}

	public GoalDto get(Long goalId) {
		return GoalDto.fromGoal(goalService.findOne(goalId));
	}

	public List<GoalDto> listAllByUser(Long userId) {
		User user = userService.findById(userId);
		List<Goal> goals = goalService.listAllByUser(user);
		return goals.stream().map(GoalDto::fromGoal).collect(Collectors.toList());
	}
}
