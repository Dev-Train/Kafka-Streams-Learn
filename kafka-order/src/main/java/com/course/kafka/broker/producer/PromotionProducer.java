package com.course.kafka.broker.producer;

import com.course.kafka.broker.message.PromotionMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.concurrent.ExecutionException;

/**
 * Created by IntelliJ IDEA
 * User: Balaji Varadharajan
 * Class/Interface/Enum Name: PromotionProducer
 * Inside the package - com.course.kafka.broker.producer
 * Created Date: 7/21/2021
 * Created Time: 4:50 PM
 **/
@Service
@Slf4j
@RequiredArgsConstructor
public class PromotionProducer {

    private final KafkaTemplate<String, PromotionMessage> kafkaTemplate;

    public void publish(PromotionMessage promotionMessage){
        /**
         * Use the get() method of the message send is to be done synchronously
         */
        try{
            var sendResult = kafkaTemplate.send("t.commodity.promotion", promotionMessage).get();
            log.info("Promotion Message Sent Successfully {}", sendResult.getProducerRecord().value());
        }catch (InterruptedException | ExecutionException exception){
            log.error("Error in publishing {}, cause {}", promotionMessage, exception.getMessage());
        }

    }
}
