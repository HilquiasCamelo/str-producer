package com.hilquiascamelo.strproducer.config;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;

/**
 * Configuração da fábrica de produtores Kafka para produzir mensagens de strings.
 */
@RequiredArgsConstructor
@Configuration
public class StringProducerFactoryConfig {

    private final KafkaProperties properties;

    /**
     * Cria uma fábrica de produtores para o Apache Kafka.
     *
     * @return A fábrica de produtores configurada.
     */
    @Bean
    public ProducerFactory<String, String> producerFactory() {
        // Configuração para a fábrica de produtores
        var config = new HashMap<String, Object>();

        // Define os servidores de inicialização
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, properties.getBootstrapServers());
        // Define a classe de serialização para a chave
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        // Define a classe de serialização para o valor
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

        return new DefaultKafkaProducerFactory<>(config);
    }

    /**
     * Cria um template Kafka para produzir mensagens.
     *
     * @param producerFactory A fábrica de produtores a ser usada pelo template.
     * @return O template Kafka configurado com a fábrica de produtores fornecida.
     */
    @Bean
    public KafkaTemplate<String, String> kafkaTemplate(ProducerFactory<String, String> producerFactory) {
        return new KafkaTemplate<>(producerFactory);
    }
}
