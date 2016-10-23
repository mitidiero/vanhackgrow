package com.vanhack.application;

import com.vanhack.application.dto.DefaultAccountancyDto;
import com.vanhack.domain.model.defaultaccountancy.DefaultAccountancy;
import com.vanhack.domain.model.defaultaccountancy.DefaultAccountancyService;
import com.vanhack.domain.model.user.User;
import com.vanhack.domain.model.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DefaultAccountancyApplicationService {

    private final static Logger log = LoggerFactory.getLogger(DefaultAccountancyApplicationService.class);

    @Autowired
    private DefaultAccountancyService defaultAccountancyService;

    @Autowired
    private UserService userService;

    public DefaultAccountancyDto create(String name, BigDecimal value, Long userId) {
        User user = userService.findById(userId);
        DefaultAccountancy defaultAccountancy = new DefaultAccountancy(name, value, user);
        defaultAccountancyService.create(defaultAccountancy);
        log.info("Created default accountancy with id {}.", defaultAccountancy.getId());
        return DefaultAccountancyDto.fromDefaultAccountancy(defaultAccountancy);
    }

    public DefaultAccountancyDto update(Long defaultAccountancyId, String name, BigDecimal value) {
        DefaultAccountancy updated = defaultAccountancyService.update(defaultAccountancyId, name, value);
        log.info("Updated default accountancy with id {}.", updated.getId());
        return DefaultAccountancyDto.fromDefaultAccountancy(updated);
    }

    public DefaultAccountancyDto get(Long defaultAccountancyId) {
        return DefaultAccountancyDto.fromDefaultAccountancy(defaultAccountancyService.findOne(defaultAccountancyId));
    }

    public List<DefaultAccountancyDto> listAllByUser(Long userId) {
        User user = userService.findById(userId);
        List<DefaultAccountancy> defaultAccountancies = defaultAccountancyService.findAllByUser(user);
        return defaultAccountancies.stream().map(DefaultAccountancyDto::fromDefaultAccountancy).collect(Collectors.toList());
    }

    public void delete(Long defaultAccountancyId) {
        defaultAccountancyService.delete(defaultAccountancyId);
    }
}
