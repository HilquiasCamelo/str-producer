package com.hilquiascamelo.strproducer.exceptions;

import com.hilquiascamelo.strproducer.model.LogEntity;
import com.hilquiascamelo.strproducer.repository.LogRepository;
import com.hilquiascamelo.strproducer.services.LogService;
import com.hilquiascamelo.strproducer.services.impl.LogServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.errors.NetworkException;
import org.apache.kafka.common.errors.SerializationException;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@RequiredArgsConstructor
public class ExceptionUtils {

    public static void setLogRepository(LogRepository repository) {
        logRepository = repository;
    }
    public static LogRepository logRepository ;
    private static long baseWaitTimeMs = 0;

    public static void handleSendFailure(Throwable ex) {

        // Crie uma instância de LogEntity com as informações relevantes
        LogEntity logEntity = new LogEntity();
        logEntity.setMessage("Erro ao enviar para o tópico: " + ex.getMessage());
        logEntity.setLogLevel("ERROR");

        // Salve o objeto LogEntity usando o serviço de log
        LogService logService = new LogServiceImpl(logRepository);
        logService.saveLog(logEntity);
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
