package com.course.kafka.broker.stream.promotion;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Printed;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by IntelliJ IDEA
 * User: Balaji Varadharajan
 * Class/Interface/Enum Name: PromotionUppercaseStream
 * Inside the package - com.course.kafka.broker.stream.promotion
 * Created Date: 7/23/2021
 * Created Time: 8:06 AM
 **/
@Configuration
public class PromotionUppercaseStream {

    @Bean
    public KStream<String, String> kStreamPromotionUppercase(StreamsBuilder streamsBuilder){
        KStream<String, String> sourceStream = streamsBuilder.stream("t.commodity.promotion", Consumed.with(Serdes.String(), Serdes.String()));
        KStream<String, String> upperCaseStream = sourceStream.mapValues(s -> s.toUpperCase());
        upperCaseStream.to("t.commodity.promotion.uppercase");

        // useful for debugging do not do in prod
        sourceStream.print(Printed.<String,String>toSysOut().withLabel("Original Stream"));
        upperCaseStream.print(Printed.<String,String>toSysOut().withLabel("Uppercase Stream"));
        return sourceStream;
    }

    @Bean
    public StreamsBuilder streamsBuilder(){
        return new StreamsBuilder();
    }
}
