package com.hcl.hackathon.controller.impl;

import com.hcl.hackathon.controller.CreditLimitController;
import com.hcl.hackathon.exception.CreditAppException;
import com.hcl.hackathon.exception.ResourceNotFoundException;
import com.hcl.hackathon.model.CreditLimitDetail;
import com.hcl.hackathon.service.CreditLimitService;
import com.hcl.hackathon.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Kuldeep Gouranna
 *
 */
@RestController
public class CreditLimitControllerImpl implements CreditLimitController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CreditLimitService creditLimitService;

    /**
     * Method to get credit card limit by passing pancard number
     *
     * @param pancardNo
     * @return Returns credit limit
     */
    @Override
    public ResponseEntity<CreditLimitDetail> getCreditLimit(String pancardNo) {

        logger.debug("Started CreditLimitControllerImpl {}",pancardNo);

        CreditLimitDetail creditLimitDetail = null;
        if(StringUtils.isEmpty(pancardNo)){
            throw new ResourceNotFoundException(HttpStatus.NOT_FOUND.value(), "pancard no is not given");
        }
        try {
            creditLimitDetail = creditLimitService.getCreditLimit(pancardNo);
        }catch (CreditAppException creditAppException) {
            logger.error("CreditAppException in CreditLimitControllerImpl ....");
            throw new CreditAppException(creditAppException.getErrorCode(), creditAppException.getMessage());
        }
        return new ResponseEntity<>(creditLimitDetail, HttpStatus.OK);
    }
}
