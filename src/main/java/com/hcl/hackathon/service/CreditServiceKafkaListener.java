package com.hcl.hackathon.service;
import com.hcl.hackathon.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class CreditServiceKafkaListener {

    private static final Logger logger = LoggerFactory.getLogger(CreditServiceKafkaListener.class);

    @KafkaListener(topics = "my_topic", groupId = "anand_group_id")
    public void userRequestListener(String customer) {
        logger.info("CreditServiceKafkaListener class creditCardRequestListener method end{} "+ customer );
    }
}
