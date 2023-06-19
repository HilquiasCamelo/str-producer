package com.hilquiascamelo.strproducer.controller;

import com.hilquiascamelo.strproducer.model.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface OrderController {

    public ResponseEntity < Order > sendOrder( @RequestBody Order order);

}
