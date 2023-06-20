package com.hilquiascamelo.strproducer.services.impl;

import com.hilquiascamelo.strproducer.model.LogEntity;
import com.hilquiascamelo.strproducer.repository.LogRepository;
import com.hilquiascamelo.strproducer.services.LogService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class LogServiceImpl implements LogService {
    private LogRepository logRepository;
    public void saveLog(String message, String logLevel) {
        // Aqui você pode criar uma instância de LogEntity com as informações recebidas
        LogEntity logEntity = new LogEntity();
        logEntity.setMessage(message);
        logEntity.setLogLevel(logLevel);
        logEntity.setTimestamp( LocalDateTime.now());

        logRepository.save(logEntity);
    }
}
