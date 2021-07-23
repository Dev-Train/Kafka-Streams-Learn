package com.course.kafka.broker.message;

import lombok.*;

/**
 * Created by IntelliJ IDEA
 * User: Balaji Varadharajan
 * Class/Interface/Enum Name: PromotionMessage
 * Inside the package - com.course.kafka.broker.message
 * Created Date: 7/21/2021
 * Created Time: 6:57 PM
 **/
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PromotionMessage {

    private String promotionCode;

    @Override
    public String toString() {
        return "PromotionMessage{" +
                "promotionCode='" + promotionCode + '\'' +
                '}';
    }
}
