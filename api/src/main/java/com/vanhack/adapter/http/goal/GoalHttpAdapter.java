package com.vanhack.adapter.http.goal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.vanhack.application.GoalApplicationService;
import com.vanhack.application.dto.GoalDto;

@RestController
public class GoalHttpAdapter {

	@Autowired
	private GoalApplicationService goalApplicationService;

	@RequestMapping(value = "/goals", method = { RequestMethod.POST })
	@ResponseStatus(HttpStatus.CREATED)
	public GoalDto create(@Valid @RequestBody final CreateGoalRequest request) {
		return goalApplicationService.create(request.getGoalName(), request.getGotAmount(), request.getGoalAmount(), request.getStartDate(),
		  request.getGoalDate(), request.getEmail());
	}

	@RequestMapping(value = "/Goals/{GoalId}", method = { RequestMethod.PUT })
	@ResponseStatus(HttpStatus.CREATED)
	public GoalDto update(@PathVariable String goalId, @Valid @RequestBody UpdateGoalRequest request) {
		return goalApplicationService.update(request.getEmail(), Long.valueOf(goalId), request.getGoalName(), request.getGotAmount(),
		  request.getGoalAmount(), request.getStartDate(), request.getGoalDate());
	}
}
