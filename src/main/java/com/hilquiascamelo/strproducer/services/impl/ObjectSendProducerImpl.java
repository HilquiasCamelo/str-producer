package com.hilquiascamelo.strproducer.services.impl;

import com.hilquiascamelo.strproducer.services.ObjectSendProducer;
import com.hilquiascamelo.strproducer.exceptions.ExceptionUtils;
import com.hilquiascamelo.strproducer.util.HasDateField;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutionException;

@Slf4j
@RequiredArgsConstructor
@Service
public class ObjectSendProducerImpl implements ObjectSendProducer {
    private final KafkaTemplate<String, Object> kafkaTemplate;
    private static final int MAX_RETRY_ATTEMPTS = 5;
    private static final long BASE_WAIT_TIME_MS = 1000; // Tempo de espera base em milissegundos



    public void send(Object object) {
        int attempt = 1; // Contador de tentativas

        while (attempt <= MAX_RETRY_ATTEMPTS) {
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
                // Envia a mensagem para o tópico
                ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send("str-topic", object);

                // Adiciona um callback para tratar o resultado do envio
                future.addCallback(this::handleSendSuccess, ExceptionUtils::handleSendFailure);

                // Aguarda a conclusão do envio
                future.get();

                // A mensagem foi enviada com sucesso, então podemos sair do loop
                break;
            } catch (ExecutionException e) {
                if (ExceptionUtils.shouldRetryOnError(e.getCause())) {
                    log.info("Retrying... Attempt: {}", attempt); // Log da tentativa de reenvio
                    attempt++; // Incrementa o contador de tentativas

                    // Espera um tempo antes da próxima tentativa
                    ExceptionUtils.waitBeforeRetry(attempt);
                } else {
                    ExceptionUtils.handleSendFailure(e.getCause());
                    throw new RuntimeException("Ocorreu um erro ao enviar a mensagem para o tópico");
                }
            } catch (InterruptedException e) {
                log.error("Erro ao pausar a execução: {}", e.getMessage());
            }
        }
    }

    private void handleSendSuccess(SendResult<String, Object> result) {
        RecordMetadata metadata = result.getRecordMetadata();
        long offset = metadata.offset();
        log.info("Mensagem enviada com sucesso para o tópico: str-topic");
        log.info("Offset: {}", offset);
    }
}
