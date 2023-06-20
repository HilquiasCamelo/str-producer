package com.hilquiascamelo.strproducer.controller.impl;
import com.hilquiascamelo.strproducer.controller.OrderController;
import com.hilquiascamelo.strproducer.model.OrderEntity;

import com.hilquiascamelo.strproducer.services.ObjectSendProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping ("/orders/create")
public class OrderControllerImpl implements OrderController {



    private final ObjectSendProducer objectSendProducer;
    @Override
    @RequestMapping ("/")
    public ResponseEntity < OrderEntity > sendOrder ( @RequestBody OrderEntity order )
        {
            objectSendProducer.send( order );
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(order);
        }
}
