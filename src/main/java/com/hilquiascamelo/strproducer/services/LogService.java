package com.hilquiascamelo.strproducer.services;

import com.hilquiascamelo.strproducer.model.LogEntity;
import org.springframework.stereotype.Service;

@Service
public interface LogService {
    void saveLog( LogEntity logEntity);
}
