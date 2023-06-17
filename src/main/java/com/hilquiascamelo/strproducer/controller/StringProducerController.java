package com.hilquiascamelo.strproducer.controller;

import com.hilquiascamelo.strproducer.model.ObjectTextModel;
import com.hilquiascamelo.strproducer.util.MessageResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface StringProducerController {

    @PostMapping
    ResponseEntity< ObjectTextModel > send( @RequestBody ObjectTextModel objectTextModel);


    @PostMapping
    ResponseEntity < MessageResponse > sendMessage( @RequestBody String message);


}
