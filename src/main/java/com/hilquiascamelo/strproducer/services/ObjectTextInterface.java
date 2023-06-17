package com.hilquiascamelo.strproducer.services;

import com.hilquiascamelo.strproducer.model.ObjectTextModel;
import org.apache.kafka.clients.producer.RecordMetadata;


public interface ObjectTextInterface {

    void send( ObjectTextModel model);

    void logInfo( String string, RecordMetadata recordMetadata);
}
