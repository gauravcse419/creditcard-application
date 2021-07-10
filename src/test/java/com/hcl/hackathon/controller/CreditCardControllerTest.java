package com.hcl.hackathon.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.hackathon.model.CustomerDetail;
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

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CreditCardController.class)
public class CreditCardControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    CreditService creditService;

    @Test
    public void updateOrderStatusWithInternalServer() throws Exception {

        Mockito.doThrow(RuntimeException.class).when(creditService).processingCreditCardApplication(Mockito.anyString());
        mvc.perform(MockMvcRequestBuilders.put("/api/v1/creditcard/applications/12345", 1)
                .content(asJsonString(getCustomerDetail())).contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isInternalServerError());
        verify(creditService).processingCreditCardApplication(Mockito.anyString());

    }

    private CustomerDetail getCustomerDetail() {
        CustomerDetail customerDetail = new CustomerDetail();
        customerDetail.setApplicationId("12345");
        customerDetail.setStatus("Approved");
        customerDetail.setDescription("Application is Approved");
        return customerDetail;
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
