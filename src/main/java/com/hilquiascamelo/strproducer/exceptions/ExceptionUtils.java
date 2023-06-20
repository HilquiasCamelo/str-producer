package com.hilquiascamelo.strproducer.exceptions;

import com.hilquiascamelo.strproducer.model.LogEntity;
import com.hilquiascamelo.strproducer.repository.LogRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.errors.NetworkException;
import org.apache.kafka.common.errors.SerializationException;

@Slf4j
public class ExceptionUtils {
    private static LogRepository logRepository = null;
    private static long baseWaitTimeMs = 0;

    public ExceptionUtils(LogRepository logRepository, long baseWaitTimeMs) {
        this.logRepository = logRepository;
        this.baseWaitTimeMs = baseWaitTimeMs;
    }

    public static void handleSendFailure ( Throwable ex ) {
        saveLog("Erro ao enviar para o tópico: " + ex.getMessage(), "ERROR");

        // Lógica personalizada de tratamento de erros
        if (ex instanceof NetworkException) {
            // Lidar com exceções de rede, se necessário
            saveLog("Erro de rede: " + ex.getMessage(), "ERROR");
            // Executar ações específicas para lidar com a exceção de rede
        } else if (ex instanceof SerializationException) {
            // Lidar com exceções de serialização, se necessário
            saveLog("Erro de serialização: " + ex.getMessage(), "ERROR");
            // Executar ações específicas para lidar com a exceção de serialização
        } else {
            // Lidar com outras exceções não tratadas anteriormente
            saveLog("Erro não tratado: " + ex.getMessage(), "ERROR");
            // Executar ações gerais de tratamento de erros
        }

        // Outras ações de tratamento de erros, se necessário
    }

    private static void saveLog ( String message ,
                                  String level ) {
        LogEntity logEntity = new LogEntity();
        logEntity.setMessage(message);
        logRepository.save(logEntity);
    }

    public static boolean shouldRetryOnError ( Throwable cause ) {
        // Lógica para determinar se uma nova tentativa de envio deve ser feita com base no erro específico

        // Exemplo: Vamos assumir que queremos reenviar apenas se a exceção for uma instância de NetworkException
        if (cause instanceof NetworkException) {
            return true;
        }

        return false;
    }

    public static void waitBeforeRetry ( int attempt ) {
        // Lógica para esperar um intervalo antes da próxima tentativa

        // Exemplo: Espera exponencial com base no número de tentativas
        long waitTimeMillis = (long) (baseWaitTimeMs * Math.pow(2, attempt - 1));
        try {
            Thread.sleep(waitTimeMillis);
        } catch (InterruptedException e) {
            saveLog("Erro ao pausar a execução: " + e.getMessage(), "ERROR");
        }
    }
}
