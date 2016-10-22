package com.vanhack.domain.model.defaultaccountancy;

import com.vanhack.domain.model.user.User;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class DefaultAccountancy {

    private Long id;
    private String name;
    private BigDecimal value;
    private User user;

    public DefaultAccountancy(String name, BigDecimal value, User user) {
        this.name = name;
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

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
