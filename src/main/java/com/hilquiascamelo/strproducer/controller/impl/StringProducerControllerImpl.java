package com.hilquiascamelo.strproducer.controller.impl;

import com.hilquiascamelo.strproducer.controller.StringProducerController;
import com.hilquiascamelo.strproducer.model.ObjectTextModel;
import com.hilquiascamelo.strproducer.services.ObjectSendProducer;

import com.hilquiascamelo.strproducer.util.MessageResponse;
import lombok.RequiredArgsConstructor;
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
@RequestMapping("/")
public class StringProducerControllerImpl implements StringProducerController {


    private final ObjectSendProducer objectSendProducer;

    /**
     * Método POST para enviar uma mensagem de string.
     *
     * @param message
     *         A mensagem a ser enviada.
     * @return Uma resposta HTTP indicando o status da operação.
     */
    @PostMapping("/message")
    public ResponseEntity < MessageResponse > sendMessage( @RequestBody String message) {
        objectSendProducer.send(message);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new MessageResponse("Mensagem enviada com sucesso!", HttpStatus.CREATED));
    }

    @PostMapping("/object")
    public ResponseEntity<ObjectTextModel> send(@RequestBody ObjectTextModel objectTextModel) {
        objectSendProducer.send(objectTextModel);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(objectTextModel);
    }
}
