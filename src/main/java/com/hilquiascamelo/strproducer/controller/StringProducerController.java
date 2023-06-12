package com.hilquiascamelo.strproducer.controller;

import com.hilquiascamelo.strproducer.services.StringProducerService;
import com.hilquiascamelo.strproducer.util.MessageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador responsável por lidar com as requisições relacionadas ao envio de mensagens de string.
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/producer")
public class StringProducerController {

    @Autowired
    private StringProducerService producerService;

    /**
     * Método POST para enviar uma mensagem de string.
     *
     * @param message A mensagem a ser enviada.
     * @return Uma resposta HTTP indicando o status da operação.
     */
    @PostMapping
    public ResponseEntity<MessageResponse> sendMessage(@RequestBody String message) {
        producerService.sendMessage(message);


        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new MessageResponse("Mensagem enviada com sucesso!" , HttpStatus.CREATED ));
    }

}
