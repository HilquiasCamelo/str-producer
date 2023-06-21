package com.hilquiascamelo.strproducer.controller;

import com.hilquiascamelo.strproducer.model.OrderEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface OrderController {

    public ResponseEntity < OrderEntity > sendOrder( @RequestBody OrderEntity order);

}
