package com.hcl.hackathon.controller.impl;

import com.hcl.hackathon.controller.CreditCardController;
import com.hcl.hackathon.exception.CreditAppException;
import com.hcl.hackathon.exception.ResourceNotFoundException;
import com.hcl.hackathon.model.CreditLimitDetail;
import com.hcl.hackathon.model.Customer;
import com.hcl.hackathon.model.CustomerDetail;
import com.hcl.hackathon.service.CreditService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<CustomerDetail> getApplicationStatus(Long applicationId) {

        logger.debug("Started CreditCardControllerImpl {}",applicationId);

        CustomerDetail customerDetail = null;
        if(StringUtils.isEmpty(applicationId)){
            throw new ResourceNotFoundException(HttpStatus.NOT_FOUND.value(), "applicationId no is not given");
        }
        try {
            customerDetail = creditService.getApplicationStatus(applicationId);
        }catch (CreditAppException creditAppException) {
            logger.error("CreditAppException in CreditCardControllerImpl ....");
            throw new CreditAppException(creditAppException.getErrorCode(), creditAppException.getMessage());
        }
        return new ResponseEntity<>(customerDetail, HttpStatus.OK);
    }


    /**
     * @param customer
     * @return
     */
    @Override
    public ResponseEntity<CustomerDetail> addCustome(Customer customer) {
        return null;
    }

    /**
     * @param applicationId
     * @return
     */
    @Override
    public ResponseEntity<CustomerDetail> applicationId(Long applicationId) {
        return null;
    }


}
