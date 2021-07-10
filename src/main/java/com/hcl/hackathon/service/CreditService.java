package com.hcl.hackathon.service;

import com.hcl.hackathon.model.Customer;
import com.hcl.hackathon.model.CustomerDetail;

public interface CreditService {

    String createCreditCard(Customer customer);
    CustomerDetail processingCreditCardApplication(String applicationId);

}
