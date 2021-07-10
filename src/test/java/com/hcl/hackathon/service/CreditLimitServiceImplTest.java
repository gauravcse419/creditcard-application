package com.hcl.hackathon.service;


import com.hcl.hackathon.entity.ApplicationDetail;
import com.hcl.hackathon.entity.Customer;
import com.hcl.hackathon.exception.ResourceNotFoundException;
import com.hcl.hackathon.model.CreditLimitDetail;
import com.hcl.hackathon.repository.CustomerJPARepository;
import com.hcl.hackathon.service.impl.CreditLimitServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;


/**
 *
 * @author Kuldeep Gouranna
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class CreditLimitServiceImplTest {
    @Mock
    CustomerJPARepository customerJPARepository;


    @InjectMocks
    CreditLimitServiceImpl creditLimitService;

    /**
     * Test case for getCreditLimit with success case with valid pancard no
     *
     */
    @Test
    public void getCreditLimitTest() {
        when(customerJPARepository.findByPancard("ABCD123")).thenReturn(getCustomer());
        CreditLimitDetail creditLimitDetail = creditLimitService.getCreditLimit("ABCD123");
        verify(customerJPARepository).findByPancard("ABCD123");
        assertThat(creditLimitDetail).isNotNull();
        assertThat(creditLimitDetail.getPanCard()).isEqualTo("ABCD123");
    }

    /**
     * TTest case for getCreditLimit with RuntimeException case
     *
     */
    @Test(expected = ResourceNotFoundException.class)
    public void getCreditLimitTestInternalServerTest() {
        when(customerJPARepository.findByPancard(Mockito.anyString())).thenThrow(ResourceNotFoundException.class);
        CreditLimitDetail creditLimitDetail = creditLimitService.getCreditLimit("ABCD123");
        verify(customerJPARepository).findByPancard("ABCD123");
        assertThat(creditLimitDetail).isNull();
    }

    /**
     * getCustomer
     *
     * @return customer
     */
    private Customer getCustomer() {
        Customer customer = new Customer();
        customer.setCustomerName("ABCD123");
        customer.setPancard("ABCD123");
        customer.setApplicationDetails(mapApplicationDetails());
        return  customer;
    }

    /**
     * mapApplicationDetails
     *
     * @return applicationDetails
     */
    private List<ApplicationDetail> mapApplicationDetails() {
        List<ApplicationDetail> applicationDetails = new ArrayList<>();
        ApplicationDetail applicationDetail = new ApplicationDetail();
        applicationDetail.setCreditLimit(50000);
        applicationDetails.add(applicationDetail);
        return  applicationDetails;
    }
}
