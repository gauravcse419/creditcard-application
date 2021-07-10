package com.hcl.hackathon.controller;

import com.hcl.hackathon.controller.impl.CreditLimitControllerImpl;
import com.hcl.hackathon.exception.ResourceNotFoundException;
import com.hcl.hackathon.model.CreditLimitDetail;
import com.hcl.hackathon.service.CreditLimitService;
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
@WebMvcTest(CreditLimitControllerImpl.class)
public class CreditLimitControllerTest {


    @Autowired
    private MockMvc mvc;

    @MockBean
    CreditLimitService creditLimitService;

    /**
     * Test case for getCreditLimit with success case with valid pancard no
     *
     * @throws Exception
     */
    @Test
    public void getCreditLimitTest() throws Exception {
    CreditLimitDetail creditLimitDetail = getCreditLimitInfo();
        when(creditLimitService.getCreditLimit(Mockito.anyString())).thenReturn(creditLimitDetail);
        mvc.perform(MockMvcRequestBuilders.get("/api/v1/creditlimit/ABCD123").accept(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.panCard").value("ABCD123"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("test1"));
        verify(creditLimitService).getCreditLimit(Mockito.anyString());
    }

    /**
     * Test case for getCreditLimit with ResourceNotFoundException case
     *
     * @throws Exception
     */
    @Test
    public void getCreditLimitTestNotFound() throws Exception {
        when(creditLimitService.getCreditLimit(Mockito.anyString()))
                .thenThrow(ResourceNotFoundException.class);
        mvc.perform(MockMvcRequestBuilders.get("/api/v1/creditlimit/ABCD123"))
                .andExpect(status().isNotFound());
        verify(creditLimitService).getCreditLimit(Mockito.anyString());

    }



    /**
     * Test case for getCreditLimit with RuntimeException case
     *
     * @throws Exception
     */
    @Test
    public void getCreditLimitTestCreditAppException() throws Exception {
        when(creditLimitService.getCreditLimit(Mockito.anyString()))
                .thenThrow(RuntimeException.class);
        mvc.perform(MockMvcRequestBuilders.get("/api/v1/creditlimit/ABCD123"))
                .andExpect(status().isInternalServerError());
        verify(creditLimitService).getCreditLimit(Mockito.anyString());

    }

    /**
     * getCreditLimitInfo
     *
     * @return CreditLimitDetail
     */
    private CreditLimitDetail getCreditLimitInfo() {
        CreditLimitDetail creditLimitDetail = new CreditLimitDetail();
        creditLimitDetail.setName("test1");
        creditLimitDetail.setPanCard("ABCD123");
        creditLimitDetail.setCibilLimit(5);
        return  creditLimitDetail;
    }
}
