package com.course.kafka.broker.producer;

import com.course.kafka.broker.message.OrderMessage;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * Created by IntelliJ IDEA
 * User: Balaji Varadharajan
 * Class/Interface/Enum Name: OrderCallBack
 * Inside the package - com.course.kafka.broker.producer
 * Created Date: 7/21/2021
 * Created Time: 6:26 AM
 **/
@Component
@Slf4j
public class OrderCallBack implements ListenableFutureCallback<SendResult<String, OrderMessage>> {
    @Override
    public void onFailure(Throwable throwable) {
        log.error("Order failed to publish");
    }

    @Override
    public void onSuccess(SendResult<String, OrderMessage> result) {
        OrderMessage message = result.getProducerRecord().value();
        log.info("Order {}, Item {} published successfully",message.getOrderNumber(),
                message.getItemName());
    }
}
