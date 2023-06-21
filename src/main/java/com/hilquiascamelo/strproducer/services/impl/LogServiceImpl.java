package com.hilquiascamelo.strproducer.services.impl;

import com.hilquiascamelo.strproducer.model.LogEntity;
import com.hilquiascamelo.strproducer.repository.LogRepository;
import com.hilquiascamelo.strproducer.services.LogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class LogServiceImpl implements LogService {
    private final LogRepository logRepository;

    public void saveLog(LogEntity log) {
        // Aqui você pode criar uma instância de LogEntity com as informações recebidas
        LogEntity logEntity = log;
        logEntity.setTimestamp( LocalDateTime.now());
        logRepository.save(logEntity);
    }
}
