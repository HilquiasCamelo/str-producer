package com.hilquiascamelo.strproducer.exceptions;

import com.hilquiascamelo.strproducer.model.LogEntity;
import com.hilquiascamelo.strproducer.repository.LogRepository;
import com.hilquiascamelo.strproducer.services.LogService;
import com.hilquiascamelo.strproducer.services.impl.LogServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.errors.NetworkException;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

@Slf4j
@RequiredArgsConstructor
public class ExceptionUtils {

    private static LogRepository logRepository;
    private static LogService logService;
    private static long baseWaitTimeMs = 0;

    public static void setLogService(LogService service) {
        logService = service;
    }

    @Autowired
    public static void setLogRepository(LogRepository repository) {
        logRepository = repository;
        logService = new LogServiceImpl(logRepository);
    }

    public static void handleSendFailure(Throwable ex) {
        if (ex != null) {
            // Create an instance of LogEntity with relevant information
            LogEntity logEntity = new LogEntity();
            logEntity.setMessage("Erro ao enviar para o tópico: " + ex.getMessage());
            logEntity.setLogLevel("ERROR");
            logEntity.setTimestamp(LocalDateTime.now());

            // Save the LogEntity object using the log service
            logService.saveLog(logEntity);
        }
    }

    private static void saveLog(String message, String level) {
        LogEntity logEntity = new LogEntity();
        logEntity.setMessage(message);
        logRepository.save(logEntity);
    }

    public static boolean shouldRetryOnError(Throwable cause) {
        // Logic to determine if a retry should be attempted based on the specific error

        // Example: Assume we want to retry only if the exception is an instance of NetworkException
        if (cause instanceof NetworkException) {
            return true;
        }

        return false;
    }

    public static void waitBeforeRetry(int attempt) {
        // Logic to wait for an interval before the next retry

        // Example: Exponential wait based on the number of attempts
        long waitTimeMillis = (long) (baseWaitTimeMs * Math.pow(2, attempt - 1));
        try {
            Thread.sleep(waitTimeMillis);
        } catch (InterruptedException e) {
            saveLog("Erro ao pausar a execução: " + e.getMessage(), "ERROR");
        }
    }


}
