package com.hcl.hackathon.service;

import com.hcl.hackathon.entity.ApplicationDetail;
import com.hcl.hackathon.exception.ResourceNotFoundException;
import com.hcl.hackathon.model.CreditLimitDetail;
import com.hcl.hackathon.model.CustomerDetail;
import com.hcl.hackathon.repository.ApplicationDetailJPARepository;
import com.hcl.hackathon.service.impl.CreditServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 *
 * @author Kuldeep Gouranna
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class CreditServiceImplTest {

    @Mock
    ApplicationDetailJPARepository applicationDetailJPARepository;

    @InjectMocks
    CreditServiceImpl creditService;


    /**
     * Test case for getCreditLimit with success case with valid pancard no
     *
     */
    @Test
    public void getCreditLimitTest() {
        when(applicationDetailJPARepository.getOne(1)).thenReturn(getApplicationDetail());
        CustomerDetail customerDetail = creditService.getApplicationStatus(1L);
        verify(applicationDetailJPARepository).getOne(1);
        assertThat(customerDetail).isNotNull();
        assertThat(customerDetail.getApplicationId()).isEqualTo("1");
    }



    /**
     * TTest case for getCreditLimit with RuntimeException case
     *
     */
    @Test(expected = ResourceNotFoundException.class)
    public void getCreditLimitTestInternalServerTest() {
        when(applicationDetailJPARepository.getOne(Mockito.anyInt())).thenThrow(ResourceNotFoundException.class);
        CustomerDetail customerDetail = creditService.getApplicationStatus(1L);
        verify(applicationDetailJPARepository).getOne(1);
        assertThat(customerDetail).isNull();
    }


    private ApplicationDetail getApplicationDetail() {
        ApplicationDetail applicationDetail = new ApplicationDetail();
        applicationDetail.setApplicationNo(1);
        applicationDetail.setStatus("Approved");
        return applicationDetail;
    }

}
