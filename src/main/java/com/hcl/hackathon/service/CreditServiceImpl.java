package com.hcl.hackathon.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.hackathon.entity.ApplicationDetail;
import com.hcl.hackathon.exception.CreditAppException;
import com.hcl.hackathon.model.CibilScoreDetail;
import com.hcl.hackathon.model.Customer;
import com.hcl.hackathon.model.CustomerDetail;
import com.hcl.hackathon.repository.CreditCardRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class CreditServiceImpl  implements CreditService{

    enum applicationStatus {APPROVED, REJECTED, IN_PROGRESS}

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    private static final String TOPIC= "my_topic";

    @Autowired
    private KafkaTemplate<String, Object> kafka;

    @Autowired
    private CreditCardRepository repository;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${cibilServicesUrl}")
    private String cibilServiceUrl;

    @Override
    public String createCreditCard(Customer customer) throws Exception {
        publishToKafka(customer);
        return "published successfully";
    }

    /**
     * Method to process the application
     *
     * @param applicationId
     * @return CustomerDetail
     */
    @Override
    public CustomerDetail processingCreditCardApplication(String applicationId) {
        logger.info("CreditServiceImpl processingCreditCardApplication {}");
        CustomerDetail customerDetail = new CustomerDetail();
        Optional<ApplicationDetail> applicationDetails = this.repository.findById(Integer.valueOf(applicationId));
        if(!applicationDetails.isPresent()) {
            throw new CreditAppException(HttpStatus.PRECONDITION_FAILED.value(), "Application Id does not exists");
        }
        ApplicationDetail applicationDetail = applicationDetails.get();
        CibilScoreDetail cibilScoreDetail = restTemplate.getForObject(cibilServiceUrl+applicationDetail.getPanCard(), CibilScoreDetail.class);
        if(cibilScoreDetail.getCibilScore()>800) {
            applicationDetail.setStatus(applicationStatus.APPROVED.name());
            this.repository.save(applicationDetail);
            customerDetail.setApplicationId(String.valueOf(applicationDetail.getApplicationNo()));
            customerDetail.setStatus(applicationStatus.APPROVED.name());
            customerDetail.setDescription("customer Application successfully processed");
        } else {
            customerDetail.setStatus(applicationStatus.REJECTED.name());
            customerDetail.setDescription("customer Application has rejected");
        }
        customerDetail.setApplicationId(String.valueOf(applicationDetail.getApplicationNo()));
        return customerDetail;
    }

    public void publishToKafka(Customer customer) throws Exception {
        this.logger.info("customer"+customer);
        ObjectMapper objectMapper = new ObjectMapper();
        String customerEvent = objectMapper.writeValueAsString(customer);
        kafka.send(TOPIC, customerEvent);
        this.logger.info("customer12345"+customer);
    }
}
