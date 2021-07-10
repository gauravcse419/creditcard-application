package com.hcl.hackathon.controller;

import com.hcl.hackathon.controller.impl.CreditCardControllerImpl;
import com.hcl.hackathon.controller.impl.CreditLimitControllerImpl;
import com.hcl.hackathon.exception.ResourceNotFoundException;
import com.hcl.hackathon.model.CreditLimitDetail;
import com.hcl.hackathon.model.CustomerDetail;
import com.hcl.hackathon.service.CreditLimitService;
import com.hcl.hackathon.service.CreditService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 *
 * @author Kuldeep Gouranna
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(CreditCardControllerImpl.class)
public class CreditCardControllerTest {


    @Autowired
    private MockMvc mvc;

    @MockBean
    CreditService creditService;

    /**
     * Test case for getApplicationStatus with success case with valid id
     *
     * @throws Exception
     */
    @Test
    public void getApplicationStatusTest() throws Exception {

        when(creditService.getApplicationStatus(Mockito.anyLong())).thenReturn(getCustomerDetail());
        mvc.perform(MockMvcRequestBuilders.get("/api/v1/creditcard/application/1").accept(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.Status").value("Appoved"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.applicationId").value("1"));
        verify(creditService).getApplicationStatus(Mockito.anyLong());
    }

    /**
     * Test case for getApplicationStatus with ResourceNotFoundException case
     *
     * @throws Exception
     */
    @Test
    public void getApplicationStatusNotFound() throws Exception {
        when(creditService.getApplicationStatus(Mockito.anyLong()))
                .thenThrow(ResourceNotFoundException.class);
        mvc.perform(MockMvcRequestBuilders.get("/api/v1/creditcard/application/1"))
                .andExpect(status().isNotFound());
        verify(creditService).getApplicationStatus(Mockito.anyLong());

    }



    /**
     * Test case for getApplicationStatus with RuntimeException case
     *
     * @throws Exception
     */
    @Test
    public void getApplicationStatusCreditAppException() throws Exception {
        when(creditService.getApplicationStatus(Mockito.anyLong()))
                .thenThrow(RuntimeException.class);
        mvc.perform(MockMvcRequestBuilders.get("/api/v1/creditcard/application/1"))
                .andExpect(status().isInternalServerError());
        verify(creditService).getApplicationStatus(Mockito.anyLong());

    }

    /**
     * CustomerDetail
     *
     * @return customerDetail
     */
    private CustomerDetail getCustomerDetail() {
        CustomerDetail customerDetail = new CustomerDetail();
        customerDetail.setStatus("Appoved");
        customerDetail.setApplicationId("1");
        return  customerDetail;
    }
}
