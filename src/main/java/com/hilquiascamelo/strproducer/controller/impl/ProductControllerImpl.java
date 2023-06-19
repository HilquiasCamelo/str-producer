package com.hilquiascamelo.strproducer.controller.impl;

import com.hilquiascamelo.strproducer.controller.ProductController;
import com.hilquiascamelo.strproducer.model.Product;
import com.hilquiascamelo.strproducer.services.ObjectSendProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@Slf4j
public class ProductControllerImpl implements ProductController {

    private final ObjectSendProducer objectSendProducer;

    @Override
    @RequestMapping("/create")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        objectSendProducer.send(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }
}
