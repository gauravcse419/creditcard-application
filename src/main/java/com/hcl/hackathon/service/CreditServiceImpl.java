package com.hcl.hackathon.service;

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

    @Value(value = "${message.topic.name}")
    private String topicName;

    @Autowired
    private KafkaTemplate<String, Customer> kafkaTemplate;

    @Autowired
    private CreditCardRepository repository;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${cibilServicesUrl}")
    private String cibilServiceUrl;

    @Override
    public String createCreditCard(Customer customer) {
        publishToKafka(customer);
        return "published successfully";
    }

    @Override
    public CustomerDetail processingCreditCardApplication(String applicationId) {
        logger.info("CreditServiceImpl processingCreditCardApplication {}");
        CustomerDetail customerDetail = new CustomerDetail();
        Optional<ApplicationDetail> applicationDetails = this.repository.findById(Integer.valueOf(applicationId));
        if(!applicationDetails.isPresent()) {
            throw new CreditAppException(HttpStatus.PRECONDITION_FAILED.value(), "Application Id does not exists");
        }
        CibilScoreDetail cibilScoreDetail = restTemplate.getForObject(cibilServiceUrl, CibilScoreDetail.class);
        ApplicationDetail applicationDetail = applicationDetails.get();
        if(cibilScoreDetail.getCibilScore()<800) {
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

    public void publishToKafka(Customer customer) {
        kafkaTemplate.send(topicName, customer);

    }
}
