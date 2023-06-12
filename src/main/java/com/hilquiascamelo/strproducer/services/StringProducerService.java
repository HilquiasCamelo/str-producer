package com.hilquiascamelo.strproducer.services;

import com.hilquiascamelo.strproducer.util.MessageResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class StringProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    /**
     * Envia uma mensagem para o tópico "str-topic" do Kafka.
     *
     * @param message A mensagem a ser enviada.
     */
    public void sendMessage(String message) {
        kafkaTemplate.send("str-topic", message).addCallback(
                success -> {
                    if (success != null) {
                        logInfo(message, success.getRecordMetadata());
                    }
                },
                error -> {
                    log.error("Erro ao enviar para o tópico");
                    throw new RuntimeException("Ocorreu um erro ao enviar a mensagem para o tópico");
                }
        );
    }

    /**
     * Registra informações sobre o envio bem-sucedido da mensagem.
     *
     * @param message        A mensagem enviada.
     * @param recordMetadata Metadados do registro enviado.
     */
    private void logInfo(String message, RecordMetadata recordMetadata) {
        String partition = String.valueOf(recordMetadata.partition());
        String offset = String.valueOf(recordMetadata.offset());

        String logMessage = String.format("Mensagem enviada com sucesso: %s\n" +
                                          "Detalhes do envio - Partição: %s, Offset: %s", message, partition, offset);

        log.info(logMessage);
    }
}
