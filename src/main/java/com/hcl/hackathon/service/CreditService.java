package com.hcl.hackathon.service;

import com.hcl.hackathon.model.CustomerDetail;

public interface CreditService {

    CustomerDetail getApplicationStatus(Long applicationId);
}
