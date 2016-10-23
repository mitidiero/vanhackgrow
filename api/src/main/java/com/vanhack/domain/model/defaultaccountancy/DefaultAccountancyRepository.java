package com.vanhack.domain.model.defaultaccountancy;

import com.vanhack.domain.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DefaultAccountancyRepository extends JpaRepository<DefaultAccountancy, Long> {

    List<DefaultAccountancy> findByUser(User user);
}
