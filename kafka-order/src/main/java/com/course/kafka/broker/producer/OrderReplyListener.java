package com.course.kafka.broker.producer;

import com.course.kafka.broker.message.OrderReplyMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA
 * User: Balaji Varadharajan
 * Class/Interface/Enum Name: OrderReplyListener
 * Inside the package - com.course.kafka.broker.producer
 * Created Date: 7/22/2021
 * Created Time: 5:44 PM
 **/
@Service
@Slf4j
public class OrderReplyListener {

    @KafkaListener(topics = "t.commodity.order.reply")
    public void listenOrderReply(OrderReplyMessage orderReplyMessage){
        log.info("Reply Message Received: {}", orderReplyMessage.getReplyMessage());
    }
}
