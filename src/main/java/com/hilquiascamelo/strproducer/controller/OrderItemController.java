package com.hilquiascamelo.strproducer.controller;

import com.hilquiascamelo.strproducer.model.OrderItem;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public interface OrderItemController {

    @PostMapping
    ResponseEntity < OrderItem > sendOrderItem(@RequestBody OrderItem orderItem);

}
