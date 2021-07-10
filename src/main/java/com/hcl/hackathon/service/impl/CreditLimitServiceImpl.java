package com.hcl.hackathon.service.impl;

import com.hcl.hackathon.entity.Customer;
import com.hcl.hackathon.exception.ResourceNotFoundException;
import com.hcl.hackathon.model.CreditLimitDetail;
import com.hcl.hackathon.repository.CustomerJPARepository;
import com.hcl.hackathon.service.CreditLimitService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 *
 * @author Kuldeep Gouranna
 *
 */
@Service
public class CreditLimitServiceImpl implements CreditLimitService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CustomerJPARepository customerJPARepository;

    /**
     * Method to get credit card limit by passing pancard number
     *
     * @param pancardNo
     * @return Returns credit limit
     */
    @Override
    public CreditLimitDetail getCreditLimit(String pancardNo) {

        logger.debug("Started CreditLimitServiceImpl {}",pancardNo);
         Customer customer = customerJPARepository.findByPancard(pancardNo);
         if(customer.equals(null)){
             logger.error("ResourceNotFoundException in CreditLimitControllerImpl ....");
             throw new ResourceNotFoundException(HttpStatus.NOT_FOUND.value(), "no details available for given pancard no");
         }
        return mapCreditLimitDetails(customer);
    }

    private CreditLimitDetail mapCreditLimitDetails(Customer customer) {
        CreditLimitDetail creditLimitDetail = new CreditLimitDetail();
        creditLimitDetail.setName(customer.getCustomerName());
        creditLimitDetail.setPanCard(customer.getPancard());
        creditLimitDetail.setCibilLimit((int) customer.getApplicationDetails().get(0).getCreditLimit());
        return creditLimitDetail;
    }


}
