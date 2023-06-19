package com.hilquiascamelo.strproducer.controller;

import com.hilquiascamelo.strproducer.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

public interface ProductController {
    @RequestMapping ("/create")
    ResponseEntity < Product > createProduct( @RequestBody Product product );
}
