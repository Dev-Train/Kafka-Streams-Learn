package com.course.kafka.api.request;

import lombok.*;

/**
 * Created by IntelliJ IDEA
 * User: Balaji Varadharajan
 * Class/Interface/Enum Name: PromotionRequest
 * Inside the package - com.course.kafka.api.request
 * Created Date: 7/21/2021
 * Created Time: 4:49 PM
 **/
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PromotionRequest {

    private String promotionCode;

    @Override
    public String toString() {
        return "PromotionRequest{" +
                "promotionCode='" + promotionCode + '\'' +
                '}';
    }
}
