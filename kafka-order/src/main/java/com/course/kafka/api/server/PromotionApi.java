package com.course.kafka.api.server;

import com.course.kafka.api.request.PromotionRequest;
import com.course.kafka.command.service.PromotionService;
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
 * Class/Interface/Enum Name: PromotionApi
 * Inside the package - com.course.kafka.api.server
 * Created Date: 7/21/2021
 * Created Time: 5:00 PM
 **/
@RestController
@RequestMapping("/api/promotion")
@RequiredArgsConstructor
public class PromotionApi {

    private final PromotionService promotionService;

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity sendPromotion(@RequestBody PromotionRequest promotionRequest){
        promotionService.createPromotion(promotionRequest);
        return new ResponseEntity(promotionRequest.getPromotionCode(), HttpStatus.CREATED);
    }
}
