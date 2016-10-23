package com.vanhack.domain.model.goal;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.vanhack.domain.model.user.User;

@Entity
public class Goal {

	private Long id;
	private String name;
	private Integer months;
	private BigDecimal value;
	private BigDecimal monthlyCost;

	private User user;

	public Goal() {
	}

	public Goal(String name, Integer months, BigDecimal value, BigDecimal monthlyCost, User user) {
		this.name = name;
		this.months = months;
		this.value = value;
		this.user = user;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal val) {
		this.value = val;
	}

	public Integer getMonths() {
		return months;
	}

	public BigDecimal getMonthlyCost() {
		return monthlyCost;
	}

	public void setMonths(Integer months) {
		this.months = months;
	}

	public void setMonthlyCost(BigDecimal monthlyCost) {
		this.monthlyCost = monthlyCost;
	}

	@ManyToOne
	@JoinColumn(name = "user_id")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Goal{" + "id=" + id + ", name='" + name + '\'' + ", value=" + value + ", months=" + months + ", monthlyCost=" + monthlyCost
		  + ", user=" + user.getName() + '}';
	}
}
