package com.course.kafka.command.action;

import com.course.kafka.api.request.PromotionRequest;
import com.course.kafka.broker.message.PromotionMessage;
import com.course.kafka.broker.producer.PromotionProducer;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA
 * User: Balaji Varadharajan
 * Class/Interface/Enum Name: PromotionAction
 * Inside the package - com.course.kafka.command.action
 * Created Date: 7/21/2021
 * Created Time: 4:57 PM
 **/
@Component
@RequiredArgsConstructor
public class PromotionAction {

    private final PromotionProducer producer;

    public void publishToKafka(PromotionRequest promotionRequest) {
        PromotionMessage promotionMessage = PromotionMessage.builder()
                .promotionCode(promotionRequest.getPromotionCode())
                .build();
        producer.publish(promotionMessage);
    }
}
