package com.vanhack.adapter.http.goal;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
		return goalApplicationService.create(request.getGoalName(), request.getValue(), request.getMonths(), request.getMonthlyCost(),
		  request.getUserId());
	}

	@RequestMapping(value = "/goals/{goalId}", method = { RequestMethod.PUT })
	@ResponseStatus(HttpStatus.OK)
	public GoalDto update(@PathVariable String goalId, @Valid @RequestBody UpdateGoalRequest request) {
		return goalApplicationService.update(Long.valueOf(goalId), request.getGoalName(), request.getValue(), request.getMonthlyCost(),
		  request.getMonths());
	}

	@RequestMapping(value = "/goals/{goalId}", method = { RequestMethod.GET })
	@ResponseStatus(HttpStatus.OK)
	public GoalDto get(@PathVariable Long goalId) {
		return goalApplicationService.get(goalId);
	}

	@RequestMapping(value = "/goals", method = { RequestMethod.GET })
	@ResponseStatus(HttpStatus.OK)
	public List<GoalDto> listAll(@RequestParam(value = "userId") Long userId) {
		return goalApplicationService.listAllByUser(userId);
	}

	@RequestMapping(value = "/goals", method = { RequestMethod.DELETE })
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long goalId) {
		goalApplicationService.delete(goalId);
	}
}
