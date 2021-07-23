package com.hcl.hackathon.controller.impl;

import com.hcl.hackathon.controller.CreditCardController;
import com.hcl.hackathon.exception.ResourceNotFoundException;
import com.hcl.hackathon.model.CustomerDetail;
import com.hcl.hackathon.service.CreditService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author Kuldeep Gouranna
 *
 */
@RestController
public class CreditCardControllerImpl implements CreditCardController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CreditService creditService;

    /**
     * Get application status by passing applicationId id
     *
     * @param applicationId
     * @return CustomerDetail
     */
    @Override
    public CustomerDetail getApplicationStatus(Long applicationId) {

        logger.debug("Started CreditCardControllerImpl {}",applicationId);

        if(StringUtils.isEmpty(applicationId)) {
            throw new ResourceNotFoundException(HttpStatus.NOT_FOUND.value(), "applicationId no is not given");
        }
        return creditService.getApplicationStatus(applicationId);
    }





}
