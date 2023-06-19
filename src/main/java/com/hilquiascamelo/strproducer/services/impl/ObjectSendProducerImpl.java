package com.hilquiascamelo.strproducer.services.impl;

import com.hilquiascamelo.strproducer.services.ObjectSendProducer;
import com.hilquiascamelo.strproducer.util.HasDateField;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@RequiredArgsConstructor
@Service
public class ObjectSendProducerImpl implements ObjectSendProducer {
    private final KafkaTemplate<String, Object> kafkaTemplate;
    private static final int MAX_RETRY_ATTEMPTS = 5;

    public void send(Object object) {
        int attempt = 1; // Contador de tentativas
        boolean sentSuccessfully = false; // Flag para indicar se a mensagem foi enviada com sucesso

        while (attempt <= MAX_RETRY_ATTEMPTS && !sentSuccessfully) {
            if (object instanceof HasDateField) {
                HasDateField hasDateField = (HasDateField) object;
                Object date = hasDateField.getDate();

                if (date instanceof String) {
                    // Verifica se a propriedade "date" é uma String
                    String dateString = (String) date;
                    LocalDateTime dateTime = LocalDateTime.parse(dateString, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
                    hasDateField.setDate(dateTime); // Atualiza a propriedade "date" com o objeto LocalDateTime
                }
            }

            try {
                // Envia a mensagem para o tópico e aguarda a confirmação
                kafkaTemplate.send("str-topic", object).get();
                logInfo(object.toString()); // Log da mensagem enviada com sucesso
                sentSuccessfully = true; // Define a flag como true para sair do loop
            } catch (Exception e) {
                log.error("Erro ao enviar para o tópico: {}", e.getMessage());

                if (attempt == MAX_RETRY_ATTEMPTS) {
                    log.error("Max retry attempts reached. Failed to send message.");
                    throw new RuntimeException("Ocorreu um erro ao enviar a mensagem para o tópico");
                } else {
                    log.info("Retrying... Attempt: {}", attempt); // Log da tentativa de reenvio
                }
            }

            attempt++; // Incrementa o contador de tentativas
        }
    }

    public void logInfo(String message) {
        log.info("Mensagem enviada com sucesso para o tópico: str-topic");
        log.info("Mensagem: {}", message);
    }
}
