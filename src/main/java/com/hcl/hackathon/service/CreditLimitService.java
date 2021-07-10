package com.hcl.hackathon.service;

import com.hcl.hackathon.model.CreditLimitDetail;

public interface CreditLimitService {

    CreditLimitDetail getCreditLimit(String pancardNo);
}
