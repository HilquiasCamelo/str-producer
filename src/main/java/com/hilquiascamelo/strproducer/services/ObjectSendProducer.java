package com.hilquiascamelo.strproducer.services;

import com.hilquiascamelo.strproducer.model.ObjectTextModel;
import org.apache.kafka.clients.producer.RecordMetadata;

public interface ObjectSendProducer {
    void send(Object object);

}
