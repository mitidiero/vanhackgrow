package com.vanhack.domain.model.goal;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vanhack.domain.model.user.User;

@Component
public class GoalService {

	@Autowired
	private GoalRepository goalRepository;

	public Goal create(Goal goal) {
		return goalRepository.save(goal);
	}

	public Goal update(Long goalId, String name, BigDecimal value, BigDecimal monthlyCost, Integer months) {
		Goal goalEntity = goalRepository.findOne(goalId);
		if (goalEntity == null) {
			throw new EntityNotFoundException("Error updating goal '" + goalId + " to database. Goal does not exits.");
		}

		goalEntity.setName(name);
		goalEntity.setValue(value);
		goalEntity.setMonths(months);
		goalEntity.setMonthlyCost(monthlyCost);

		return goalRepository.save(goalEntity);
	}

	public List<Goal> listAllByUser(User user) {
		return goalRepository.findByUser(user);
	}

	public Goal findOne(Long goalId) {
		Goal goal = goalRepository.findOne(goalId);
		if (goal == null) {
			throw new EntityNotFoundException("Error getting goal '" + goalId + " from database. Goal does not exits.");
		}

		return goal;
	}

	public void delete(Long goalId) {
		Goal goal = goalRepository.findOne(goalId);
		if (goal == null) {
			throw new EntityNotFoundException("Error deleting goal '" + goalId + " from database. Goal does not exits.");
		}

		goalRepository.delete(goal);
	}

}
