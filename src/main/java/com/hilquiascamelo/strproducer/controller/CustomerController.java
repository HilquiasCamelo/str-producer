package com.hilquiascamelo.strproducer.controller;

import com.hilquiascamelo.strproducer.model.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

public interface CustomerController {
    @RequestMapping ("/create")
    ResponseEntity < Customer > createCustomer( @RequestBody Customer customer );
}
