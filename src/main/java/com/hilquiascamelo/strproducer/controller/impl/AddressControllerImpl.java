package com.hilquiascamelo.strproducer.controller.impl;

import com.hilquiascamelo.strproducer.controller.AddressController;
import com.hilquiascamelo.strproducer.model.Address;
import com.hilquiascamelo.strproducer.services.AddressService;
import com.hilquiascamelo.strproducer.services.ObjectSendProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
@RequiredArgsConstructor
public class AddressControllerImpl implements AddressController {

    private final AddressService addressService;
    private final ObjectSendProducer addressProducer;

    @Override
    @GetMapping("/all")
    public List<Address> findAll() {
        return ResponseEntity.status(HttpStatus.CREATED).body(addressService.findAll())
                .getBody( );
    }

    @Override
    @GetMapping("/{id}")
    public Address findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.CREATED).body(addressService.findById(id))
                .getBody( );
    }

    @Override
    @PostMapping("/save")
    public ResponseEntity<List<Address>> save ( @RequestBody List < Address > addresses ) {
        addressProducer.send(addresses);
        List<Address> savedAddresses = addressService.save(addresses);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAddresses);
    }
}
