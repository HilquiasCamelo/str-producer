package com.hilquiascamelo.strproducer.services.impl;

import com.hilquiascamelo.strproducer.model.ObjectTextModel;
import com.hilquiascamelo.strproducer.services.ObjectTextInterface;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class ObjectTextInterfaceImpl implements ObjectTextInterface {

    private final KafkaTemplate<String, ObjectTextModel> kafkaTemplate;

    @Override
    public void send(ObjectTextModel objectTextModel) {
        kafkaTemplate.send("str-topic", objectTextModel).addCallback(
                success -> {
                    if (success != null) {
                        logInfo(objectTextModel.toString(), success.getRecordMetadata());
                    }
                },
                error -> {
                    log.error("Erro ao enviar para o tópico");
                    throw new RuntimeException("Ocorreu um erro ao enviar a mensagem para o tópico");
                }
        );
    }

    public void logInfo(String message, RecordMetadata metadata) {
        log.info("Mensagem enviada com sucesso para o tópico: {}", metadata.topic());
        log.info("Offset: {}", metadata.offset());
        log.info("Partition: {}", metadata.partition());
        log.info("Mensagem: {}", message);
    }
}
