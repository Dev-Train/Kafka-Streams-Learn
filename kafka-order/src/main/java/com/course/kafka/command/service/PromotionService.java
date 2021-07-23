package com.course.kafka.command.service;

import com.course.kafka.api.request.PromotionRequest;
import com.course.kafka.command.action.PromotionAction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA
 * User: Balaji Varadharajan
 * Class/Interface/Enum Name: PromotionService
 * Inside the package - com.course.kafka.command.service
 * Created Date: 7/21/2021
 * Created Time: 4:57 PM
 **/
@Service
@RequiredArgsConstructor
public class PromotionService {

    private final PromotionAction action;

    public void createPromotion(PromotionRequest promotionRequest){
        action.publishToKafka(promotionRequest);
    }
}
