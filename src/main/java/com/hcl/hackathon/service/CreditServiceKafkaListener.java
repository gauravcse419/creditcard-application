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



    @KafkaListener(topics = "${message.topic.name}", containerFactory = "customerRequestKafkaListenerContainerFactory")
    public void userRequestListener(Customer customer) {

        logger.info("UserServiceListener class creditCardRequestListener method end{} "+ customer.getPancard() );


    }
}
