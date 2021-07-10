package com.hcl.hackathon.service;

import com.hcl.hackathon.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class CreditServiceImpl  implements CreditService{

    @Value(value = "${message.topic.name}")
    private String topicName;

    @Autowired
    private KafkaTemplate<String, Customer> KafkaTemplate;

    @Override
    public String createCreditCard(Customer customer) {
        publishToKafka(customer);
        return "published successfully";
    }

    public void publishToKafka(Customer customer) {
        KafkaTemplate.send(topicName, customer);

    }
}
