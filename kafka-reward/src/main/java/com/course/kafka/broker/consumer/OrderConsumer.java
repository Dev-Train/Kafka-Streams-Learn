package com.course.kafka.broker.consumer;

import com.course.kafka.broker.message.OrderMessage;
import com.course.kafka.broker.message.OrderReplyMessage;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA
 * User: Balaji Varadharajan
 * Class/Interface/Enum Name: OrderConsumer
 * Inside the package - com.course.kafka.broker.consumer
 * Created Date: 7/22/2021
 * Created Time: 5:28 PM
 **/
@Service
@Slf4j
public class OrderConsumer {

    @KafkaListener(topics = "t.commodity.order")
    @SendTo("t.commodity.order.reply")
    public OrderReplyMessage consumeOrder(ConsumerRecord<String, OrderMessage> record){
        var headers = record.headers();
        var message = record.value();
        log.info("Processing Order {}, item {}, credit card number {}", message.getOrderNumber(), message.getItemName(), message.getCreditCardNumber());
        log.info("Headers are :");
        headers.forEach(header -> log.info("Key:{}, Value: {}", header.key(), new String(header.value())));
        var bonusPercentage = Double.parseDouble(new String(headers.lastHeader("surpriseBonus").value()));
        var bonusAmount = (bonusPercentage/100) * message.getPrice() * message.getQuantity();
        log.info("Surprise Bonus is {}", bonusAmount);
        OrderReplyMessage orderReplyMessage = OrderReplyMessage.builder()
                .replyMessage("Order:" + message.getOrderNumber() + "; Item:" + message.getItemName() + " processed.")
                .build();
        return orderReplyMessage;
    }
}
