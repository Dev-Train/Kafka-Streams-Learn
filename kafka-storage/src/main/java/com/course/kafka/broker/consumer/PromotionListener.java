package com.course.kafka.broker.consumer;

import com.course.kafka.broker.message.PromotionMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA
 * User: Balaji Varadharajan
 * Class/Interface/Enum Name: PromotionListener
 * Inside the package - com.course.kafka.broker.consumer
 * Created Date: 7/21/2021
 * Created Time: 6:59 PM
 **/
@Service
@Slf4j
@RequiredArgsConstructor
@KafkaListener(topics = "t.commodity.promotion")
public class PromotionListener {

    @KafkaHandler
    public void consumePromotionCode(PromotionMessage promotionMessage){
        log.info("Processing Promotion: {}", promotionMessage);
    }
}
