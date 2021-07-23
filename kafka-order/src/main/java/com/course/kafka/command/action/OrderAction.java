package com.course.kafka.command.action;

import com.course.kafka.api.request.OrderItemRequest;
import com.course.kafka.api.request.OrderRequest;
import com.course.kafka.broker.message.OrderMessage;
import com.course.kafka.broker.producer.OrderProducer;
import com.course.kafka.entity.Order;
import com.course.kafka.entity.OrderItem;
import com.course.kafka.repository.OrderItemRepository;
import com.course.kafka.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA
 * User: Balaji Varadharajan
 * Class/Interface/Enum Name: OrderAction
 * Inside the package - com.course.kafka.command.action
 * Created Date: 7/21/2021
 * Created Time: 3:48 PM
 **/
@Component
@RequiredArgsConstructor
public class OrderAction {

    private final OrderProducer orderProducer;

    private final OrderRepository orderRepository;

    private final OrderItemRepository orderItemRepository;

    public Order convertToOrder(OrderRequest orderRequest) {
        if(orderRequest == null){
            return null;
        }
        Order order = Order.builder()
                .creditCardNumber(orderRequest.getCreditCardNumber())
                .orderLocation(orderRequest.getOrderLocation())
                .orderDateTime(LocalDateTime.now())
                .orderNumber(RandomStringUtils.randomAlphanumeric(8).toUpperCase())
                .build();
        
        List<OrderItem> items = orderRequest.getOrderItems().stream().map(this :: convertToOrderItem).collect(Collectors.toList());
        items.forEach(orderItem -> orderItem.setOrder(order));
        order.setItems(items);
        
        return order;
    }

    private OrderItem convertToOrderItem(OrderItemRequest orderItemRequest) {
        return OrderItem.builder()
                .itemName(orderItemRequest.getItemName())
                .price(orderItemRequest.getPrice())
                .quantity(orderItemRequest.getQuantity())
                .build();
    }

    public Order saveOrder(Order order) {
        Order savedOrder = orderRepository.save(order);
        order.getItems().forEach(orderItem -> orderItemRepository.save(orderItem));
        return savedOrder;
    }

    public void publishToKakfka(OrderItem orderItem) {
        OrderMessage orderMessage = OrderMessage.builder()
                .itemName(orderItem.getItemName())
                .price(orderItem.getPrice())
                .quantity(orderItem.getQuantity())
                .orderDateTime(orderItem.getOrder().getOrderDateTime())
                .creditCardNumber(orderItem.getOrder().getCreditCardNumber())
                .orderLocation(orderItem.getOrder().getOrderLocation())
                .orderNumber(orderItem.getOrder().getOrderNumber())
                .build();
        orderProducer.publish(orderMessage);
    }
}
