package com.vanhack.domain.model.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User create(User user) {
        return userRepository.save(user);
    }

    public User update(Long userId, String name, BigDecimal total) {
        User user = userRepository.findOne(userId);
        if (user == null) {
            throw new EntityNotFoundException("Error updating user '"
                    + userId + " to database. User does not exits.");
        }

        user.setName(name);
        user.setTotal(total);

        return userRepository.save(user);
    }

    public User findByEmail(String email) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new EntityNotFoundException("Error finding user '"
                    + email + " from database. User does not exits.");
        }

        return user;
    }
}
