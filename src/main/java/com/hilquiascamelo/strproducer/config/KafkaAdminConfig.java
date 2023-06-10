package com.hilquiascamelo.strproducer.config;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;

/**
 * Classe de configuração para o KafkaAdmin.
 */
@Configuration
@RequiredArgsConstructor
public class KafkaAdminConfig {

    private final KafkaProperties properties;

    /**
     * Configuração do KafkaAdmin para a conexão com o cluster Kafka.
     *
     * @return O objeto KafkaAdmin configurado.
     */
    @Bean
    public KafkaAdmin kafkaAdmin() {
        HashMap<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, properties.getBootstrapServers());
        return new KafkaAdmin(configs);
    }

    /**
     * Configuração dos tópicos no KafkaAdmin.
     *
     * @return Um objeto KafkaAdmin.NewTopics com os tópicos configurados.
     */
    @Bean
    public KafkaAdmin.NewTopics topics() {
        return new KafkaAdmin.NewTopics(
                TopicBuilder.name("str-topic").partitions(2).replicas(1).build()
        );
    }
}
