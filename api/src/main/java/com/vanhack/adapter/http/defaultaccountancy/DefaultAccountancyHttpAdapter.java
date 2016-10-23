package com.vanhack.adapter.http.defaultaccountancy;

import com.vanhack.application.DefaultAccountancyApplicationService;
import com.vanhack.application.dto.DefaultAccountancyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DefaultAccountancyHttpAdapter {

    @Autowired
    private DefaultAccountancyApplicationService defaultAccountancyApplicationService;

    @RequestMapping(value = "/default-accountancy", method = { RequestMethod.POST })
    @ResponseStatus(HttpStatus.CREATED)
    public DefaultAccountancyDto create(@Valid @RequestBody final CreateDefaultAccountancyRequest request) {
        return defaultAccountancyApplicationService.create(
                request.getName(),
                request.getValue(),
                request.getUserId());
    }

    @RequestMapping(value = "/default-accountancy/{defaultAccountancyId}", method = { RequestMethod.PUT })
    @ResponseStatus(HttpStatus.OK)
    public DefaultAccountancyDto update(@PathVariable String defaultAccountancyId, @Valid @RequestBody UpdateDefaultAccountancyRequest request) {
        return defaultAccountancyApplicationService.update(
                Long.valueOf(defaultAccountancyId),
                request.getName(),
                request.getValue());
    }

    @RequestMapping(value = "/default-accountancy/{defaultAccountancyId}", method = { RequestMethod.GET })
    @ResponseStatus(HttpStatus.OK)
    public DefaultAccountancyDto get(@PathVariable Long defaultAccountancyId) {
        return defaultAccountancyApplicationService.get(defaultAccountancyId);
    }

    @RequestMapping(value = "/default-accountancy", method = { RequestMethod.GET })
    @ResponseStatus(HttpStatus.OK)
    public List<DefaultAccountancyDto> listAll(@RequestParam(value = "userId") Long userId) {
        return defaultAccountancyApplicationService.listAllByUser(userId);
    }

    @RequestMapping(value = "/default-accountancy", method = { RequestMethod.DELETE })
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long defaultAccountancyId) {
        defaultAccountancyApplicationService.delete(defaultAccountancyId);
    }
}
