package com.course.kafka.broker.consumer;

import com.course.kafka.broker.message.OrderMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA
 * User: Balaji Varadharajan
 * Class/Interface/Enum Name: OrderListener
 * Inside the package - com.course.kafka.broker.consumer
 * Created Date: 7/21/2021
 * Created Time: 4:43 PM
 **/
@Service
@Slf4j
public class OrderListener {

    @KafkaListener(topics = "t.commodity.order")
    public void consumeOrderMessage(OrderMessage orderMessage){
        int totalItemAmount = orderMessage.getPrice() * orderMessage.getQuantity();
        log.info("Processing Order: {}, item {}, credit card number {}, total amount {}", orderMessage.getOrderNumber(),
                orderMessage.getItemName(), orderMessage.getCreditCardNumber(), totalItemAmount);
    }
}
