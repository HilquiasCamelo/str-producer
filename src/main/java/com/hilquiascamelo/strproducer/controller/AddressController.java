package com.hilquiascamelo.strproducer.controller;

import com.hilquiascamelo.strproducer.model.Address;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface AddressController {


    List < Address > findAll ( );

    @GetMapping ("/{id}")
    Address findById ( @PathVariable Long id );

    @PostMapping("/save")
    ResponseEntity <List<Address>> save ( @RequestBody List < Address > addresses );
}
