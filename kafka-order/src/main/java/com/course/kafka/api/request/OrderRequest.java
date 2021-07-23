package com.course.kafka.api.request;

import lombok.*;

import java.util.List;

/**
 * Created by IntelliJ IDEA
 * User: Balaji Varadharajan
 * Class/Interface/Enum Name: OrderRequest
 * Inside the package - com.course.kafka.api.request
 * Created Date: 7/21/2021
 * Created Time: 3:46 PM
 **/
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {

    private String orderLocation;

    private String creditCardNumber;

    private List<OrderItemRequest> orderItems;

    @Override
    public String toString() {
        return "OrderRequest{" +
                "orderLocation='" + orderLocation + '\'' +
                ", creditCardNumber='" + creditCardNumber + '\'' +
                ", orderItems=" + orderItems +
                '}';
    }
}
