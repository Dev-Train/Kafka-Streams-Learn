package com.course.kafka.api.server;

import com.course.kafka.api.request.OrderRequest;
import com.course.kafka.api.response.OrderResponse;
import com.course.kafka.command.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA
 * User: Balaji Varadharajan
 * Class/Interface/Enum Name: OrderApi
 * Inside the package - com.course.kafka.api.server
 * Created Date: 7/21/2021
 * Created Time: 3:46 PM
 **/
@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderApi {

    private final OrderService orderService;

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest orderRequest){
        // 1. save order using service
        String orderNumber = orderService.saveOrder(orderRequest);

        // 2. Create order Response
        OrderResponse orderResponse = OrderResponse.builder()
                .orderNumber(orderNumber)
                .build();
        // 3. Return order response as response entity
        return new ResponseEntity<>(orderResponse, HttpStatus.CREATED);
    }
}
