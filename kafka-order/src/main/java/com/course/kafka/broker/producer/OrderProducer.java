package com.course.kafka.broker.producer;

import com.course.kafka.broker.message.OrderMessage;
import com.course.kafka.entity.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.Header;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * User: Balaji Varadharajan
 * Class/Interface/Enum Name: OrderProducer
 * Inside the package - com.course.kafka.broker.producer
 * Created Date: 7/21/2021
 * Created Time: 6:20 AM
 **/
@Service
@RequiredArgsConstructor
@Slf4j
public class OrderProducer {

    private final KafkaTemplate<String, OrderMessage> kafkaTemplate;

    private final OrderCallBack orderCallBack;


    private ProducerRecord<String, OrderMessage> buildProducerRecord(OrderMessage orderMessage){
        int surpriseBonus = StringUtils.startsWithIgnoreCase(orderMessage.getOrderLocation(),"A") ? 25 : 15;
        List<Header> headers = new ArrayList<>();
        var surpriseBonusHeader = new RecordHeader("surpriseBonus", Integer.toString(surpriseBonus).getBytes());
        headers.add(surpriseBonusHeader);
        return new ProducerRecord<String, OrderMessage>(
                "t.commodity.order",
                null,
                orderMessage.getOrderNumber(),
                orderMessage, headers);
    }


    public void publish(OrderMessage message){

        var producerRecord = buildProducerRecord(message);
        kafkaTemplate.send(producerRecord).addCallback(orderCallBack);
        log.info("Message after sending the order to Kafka Topic");
    }
}
