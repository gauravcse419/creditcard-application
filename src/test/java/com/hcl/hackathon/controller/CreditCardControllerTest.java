package com.hcl.hackathon.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.hackathon.model.Customer;
import com.hcl.hackathon.model.CustomerDetail;
import com.hcl.hackathon.service.CreditService;
import org.junit.Before;
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
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CreditCardController.class)
public class CreditCardControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    CreditService creditService;

    CustomerDetail customerDetail;
    Customer customer;

    @Before
    public void setUp() {
        customer = new Customer();
        customer.setName("Gaurav");
        customer.setAddress("Bangalore");
        customer.setAnnualSalary(Double.valueOf(123456));
        customer.setDob("28/09");
        customer.setPancard("1245");
        customerDetail = new CustomerDetail();
        customerDetail.setApplicationId("12345");
        customerDetail.setStatus("Approved");
        customerDetail.setDescription("Application is Approved");
    }

    @Test
    public void updateOrderStatusWithInternalServer() throws Exception {
        when(creditService.processingCreditCardApplication("12345")).thenReturn(customerDetail);
        mvc.perform(MockMvcRequestBuilders.put("/api/v1/creditcard/applications/12345", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    public void createCustomer() throws Exception {
        this.mvc.perform(MockMvcRequestBuilders.post("/api/v1/creditcard")
                .content(asJsonString(customer)).contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
        Mockito.verify(creditService).createCreditCard(getCustomer());
    }

    private Customer getCustomer() {
        Customer customer = new Customer();
        customer.setName("Gaurav");
        customer.setAddress("Bangalore");
        customer.setAnnualSalary(Double.valueOf(123456));
        customer.setDob("28/09");
        customer.setPancard("1245");
        return customer;

    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
