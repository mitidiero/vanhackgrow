package com.vanhack.application;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vanhack.application.dto.GoalDto;
import com.vanhack.domain.model.goal.Goal;
import com.vanhack.domain.model.goal.GoalService;
import com.vanhack.domain.model.user.User;
import com.vanhack.domain.model.user.UserService;
import org.springframework.stereotype.Service;

@Service
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

	public GoalDto update(String userEmail, Long goalID, String goalName, BigDecimal gotAmount, BigDecimal goalAmount, LocalDate startDate,
	  LocalDate goalDate) {
		// User user = userService.findByEmail(userEmail);
		Goal updated = goalService.update(goalID, goalName, gotAmount, goalAmount, startDate, goalDate);
		log.info("Updated goal with id {}.", updated.getId());
		return GoalDto.fromGoal(updated);
	}

	public GoalDto get(String userEmail, Long goalID) {
		return GoalDto.fromGoal(goalService.findOne(goalID));
	}

	public List<GoalDto> listAll(String userEmail) {
		List<Goal> listAll = goalService.listAll();
		List<GoalDto> list = new ArrayList<>(listAll.size());
		for (Goal goal : listAll) {
			list.add(GoalDto.fromGoal(goal));
		}
		return list;
	}
}
