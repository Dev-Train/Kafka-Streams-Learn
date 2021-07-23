package com.course.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
 * Created by IntelliJ IDEA
 * User: Balaji Varadharajan
 * Class/Interface/Enum Name: KafkaConfig
 * Inside the package - com.course.kafka.config
 * Created Date: 7/20/2021
 * Created Time: 5:27 AM
 **/
@Configuration
public class KafkaConfig {

    /**
     * Create the topic, if one doesn't exist
     * @return
     */
    @Bean
    public NewTopic topicOrder(){
        return TopicBuilder.name("t.commodity.order").partitions(1).replicas(1).build();
    }

    /**
     * Create the topic, if one doesn't exist
     * @return
     */
    @Bean
    public NewTopic topicOrderReply(){
        return TopicBuilder.name("t.commodity.order.reply").partitions(1).replicas(1).build();
    }
}
