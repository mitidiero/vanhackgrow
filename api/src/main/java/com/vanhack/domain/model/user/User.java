package com.vanhack.domain.model.user;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class User {

    private Long id;
    private String name;
    private String email;
    private BigDecimal total;

    public User() {
    }

    public User(String name, String email, BigDecimal total) {
        this.name = name;
        this.email = email;
        this.total = total;
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

    @Column(unique = true)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", total=" + total +
                '}';
    }
}
