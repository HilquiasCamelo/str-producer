package com.hilquiascamelo.strproducer.services;

import org.springframework.stereotype.Service;

@Service
public interface LogService {
    void saveLog(String message, String logLevel);
}
