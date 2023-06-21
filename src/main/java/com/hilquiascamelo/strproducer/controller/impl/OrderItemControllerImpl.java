package com.hilquiascamelo.strproducer.controller.impl;

import com.hilquiascamelo.strproducer.controller.OrderItemController;
import com.hilquiascamelo.strproducer.model.OrderItem;
import com.hilquiascamelo.strproducer.services.ObjectSendProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders/item/create")
@RequiredArgsConstructor
public class OrderItemControllerImpl implements OrderItemController {

    private ObjectSendProducer objectSendProducer;
    @Override
    @PostMapping ("/")
    public ResponseEntity < OrderItem > sendOrderItem ( OrderItem orderItem )
        {
            objectSendProducer.send(orderItem);

            return ResponseEntity.status( HttpStatus.CREATED)
                    .body(orderItem);
        }
}
