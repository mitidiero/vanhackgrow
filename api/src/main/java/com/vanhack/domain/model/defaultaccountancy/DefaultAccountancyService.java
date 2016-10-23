package com.vanhack.domain.model.defaultaccountancy;

import com.vanhack.domain.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.util.List;

@Component
public class DefaultAccountancyService {

    @Autowired
    private DefaultAccountancyRepository defaultAccountancyRepository;

    public DefaultAccountancy create(DefaultAccountancy defaultAccountancy) {
        return defaultAccountancyRepository.save(defaultAccountancy);
    }

    public DefaultAccountancy update(Long defaultAccountancyId, String name, BigDecimal value) {
        DefaultAccountancy defaultAccountancy = defaultAccountancyRepository.findOne(defaultAccountancyId);
        if (defaultAccountancy == null) {
            throw new EntityNotFoundException("Error updating default accountancy '"
                    + defaultAccountancyId + " to database. Default accountancy does not exits.");
        }

        defaultAccountancy.setName(name);
        defaultAccountancy.setValue(value);

        return defaultAccountancyRepository.save(defaultAccountancy);
    }

    public List<DefaultAccountancy> findAllByUser(User user) {
        return defaultAccountancyRepository.findByUser(user);
    }

    public DefaultAccountancy findOne(Long defaultAccountancyId) {
        DefaultAccountancy defaultAccountancy = defaultAccountancyRepository.findOne(defaultAccountancyId);
        if (defaultAccountancy == null) {
            throw new EntityNotFoundException("Error getting default accountancy '"
                    + defaultAccountancyId + " from database. Default accountancy does not exits.");
        }

        return defaultAccountancy;
    }

    public void delete(Long defaultAccountancyId) {
        DefaultAccountancy defaultAccountancy = defaultAccountancyRepository.findOne(defaultAccountancyId);
        if (defaultAccountancy == null) {
            throw new EntityNotFoundException("Error deleting default accountancy '"
                    + defaultAccountancyId + " from database. Default accountancy does not exits.");
        }

        defaultAccountancyRepository.delete(defaultAccountancy);
    }
}
