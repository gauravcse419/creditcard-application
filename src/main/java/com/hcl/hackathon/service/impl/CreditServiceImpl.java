package com.hcl.hackathon.service.impl;

import com.hcl.hackathon.entity.ApplicationDetail;
import com.hcl.hackathon.model.CustomerDetail;
import com.hcl.hackathon.repository.ApplicationDetailJPARepository;

import com.hcl.hackathon.service.CreditService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Kuldeep Gouranna
 *
 */
@Service
public class CreditServiceImpl implements CreditService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ApplicationDetailJPARepository applicationDetailJPARepository;

    /**
     * Get application status by passing applicationId id
     *
     * @param applicationId
     * @return CustomerDetail
     */
    @Override
    public CustomerDetail getApplicationStatus(Long applicationId) {
        logger.debug("Started CreditServiceImpl {}",applicationId);
        ApplicationDetail applicationDetail =applicationDetailJPARepository.getOne(applicationId.intValue());
        return getApplicationDetail(applicationDetail);
    }

    private CustomerDetail getApplicationDetail(ApplicationDetail applicationDetail) {
        CustomerDetail customerDetail = new CustomerDetail();
        customerDetail.setApplicationId(String.valueOf(applicationDetail.getApplicationNo()));
        customerDetail.setStatus(applicationDetail.getStatus());
        return customerDetail;
    }
}
