package com.course.kafka.command.service;

import com.course.kafka.api.request.OrderRequest;
import com.course.kafka.command.action.OrderAction;
import com.course.kafka.entity.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA
 * User: Balaji Varadharajan
 * Class/Interface/Enum Name: OrderService
 * Inside the package - com.course.kafka.command.service
 * Created Date: 7/21/2021
 * Created Time: 3:48 PM
 **/
@Service
@Slf4j
@RequiredArgsConstructor
public class OrderService {

    private final OrderAction orderAction;

    public String saveOrder(OrderRequest orderRequest){
        // 1. Convert Order Request Object to Order object
        Order order = orderAction.convertToOrder(orderRequest);

        // 2. Save order to data base
        order = orderAction.saveOrder(order);

        // 3. Flatten the item and order as kafka message and publish
        order.getItems().forEach(orderAction :: publishToKakfka);

        // 4. return order number
        return order.getOrderNumber();
    }
}
