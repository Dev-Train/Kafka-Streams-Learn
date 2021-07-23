package com.course.kafka.api.request;

import lombok.*;

/**
 * Created by IntelliJ IDEA
 * User: Balaji Varadharajan
 * Class/Interface/Enum Name: OrderItemRequest
 * Inside the package - com.course.kafka.api.request
 * Created Date: 7/21/2021
 * Created Time: 3:46 PM
 **/
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemRequest {

    private String itemName;

    private int price;

    private int quantity;

    @Override
    public String toString() {
        return "OrderItemRequest{" +
                "itemName='" + itemName + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
