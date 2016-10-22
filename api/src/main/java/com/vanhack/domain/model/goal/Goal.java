package com.vanhack.domain.model.goal;

import com.vanhack.domain.model.user.User;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Goal {

    private Long id;
    private String name;
    private BigDecimal got;
    private BigDecimal goal;
    private LocalDate startDate;
    private LocalDate goalDate;
    private User user;

    public Goal() {
    }

    public Goal(String name, BigDecimal got, BigDecimal goal, LocalDate startDate, LocalDate goalDate, User user) {
        this.name = name;
        this.got = got;
        this.goal = goal;
        this.startDate = startDate;
        this.goalDate = goalDate;
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

    public BigDecimal getGot() {
        return got;
    }

    public void setGot(BigDecimal got) {
        this.got = got;
    }

    public BigDecimal getGoal() {
        return goal;
    }

    public void setGoal(BigDecimal goal) {
        this.goal = goal;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getGoalDate() {
        return goalDate;
    }

    public void setGoalDate(LocalDate goalDate) {
        this.goalDate = goalDate;
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
        return "Goal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", got=" + got +
                ", goal=" + goal +
                ", startDate=" + startDate +
                ", goalDate=" + goalDate +
                ", user=" + user.getName() +
                '}';
    }
}
