package com.course.kafka.repository;

import com.course.kafka.entity.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA
 * User: Balaji Varadharajan
 * Class/Interface/Enum Name: OrderRepository
 * Inside the package - com.course.kafka.repository
 * Created Date: 7/21/2021
 * Created Time: 6:08 AM
 **/
@Repository
public interface OrderRepository extends CrudRepository<Order, Integer> {
}
