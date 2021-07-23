package com.course.kafka.broker.message;

import lombok.*;

/**
 * Created by IntelliJ IDEA
 * User: Balaji Varadharajan
 * Class/Interface/Enum Name: OrderReplyMessage
 * Inside the package - com.course.kafka.broker.message
 * Created Date: 7/22/2021
 * Created Time: 5:44 PM
 **/
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderReplyMessage {

    private String replyMessage;

    @Override
    public String toString() {
        return "OrderReplyMessage{" +
                "replyMessage='" + replyMessage + '\'' +
                '}';
    }
}
