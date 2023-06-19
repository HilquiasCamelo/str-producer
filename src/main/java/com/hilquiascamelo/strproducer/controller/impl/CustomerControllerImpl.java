package com.hilquiascamelo.strproducer.controller.impl;

import com.hilquiascamelo.strproducer.controller.CustomerController;
import com.hilquiascamelo.strproducer.model.Customer;
import com.hilquiascamelo.strproducer.services.ObjectSendProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
@Slf4j
public class CustomerControllerImpl implements CustomerController {

    private final ObjectSendProducer objectSendProducer;

    @Override
    @RequestMapping("/create")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        objectSendProducer.send(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(customer);
    }
}
