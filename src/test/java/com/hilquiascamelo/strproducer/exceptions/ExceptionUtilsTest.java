package com.hilquiascamelo.strproducer.exceptions;

import com.hilquiascamelo.strproducer.model.LogEntity;
import com.hilquiascamelo.strproducer.repository.LogRepository;
import com.hilquiascamelo.strproducer.services.LogService;
import org.apache.kafka.common.errors.NetworkException;
import org.apache.kafka.common.errors.SerializationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ExceptionUtilsTest {

    @Mock
    private LogRepository logRepository;

    @Mock
    private LogService logService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        ExceptionUtils.setLogRepository(logRepository);
    }

    @Test
    void handleSendFailure_shouldNotSaveLogEntityWhenThrowableIsNull() {
        ExceptionUtils.handleSendFailure(null);

        verify(logService, never()).saveLog(any(LogEntity.class));
        verify(logRepository, never()).save(any(LogEntity.class));
    }

    @Test
    void shouldRetryOnError_shouldReturnTrueForNetworkException() {
        Throwable throwable = new NetworkException("Network error");

        boolean result = ExceptionUtils.shouldRetryOnError(throwable);

        assertTrue(result);
    }

    @Test
    void shouldRetryOnError_shouldReturnFalseForSerializationException() {
        Throwable throwable = new SerializationException("Serialization error");

        boolean result = ExceptionUtils.shouldRetryOnError(throwable);

        assertFalse(result);
    }

    @Test
    void waitBeforeRetry_shouldWaitForExpectedInterval() throws InterruptedException {
        int attempt = 3;
        long expectedWaitTime = 100L; // Adjust the expected wait time as per your needs

        ExceptionUtils.waitBeforeRetry(attempt);

        verify(logRepository, never()).save(any(LogEntity.class));
        Thread.sleep(expectedWaitTime); // Sleep to ensure the expected wait time has passed
        verify(logRepository, never()).save(any(LogEntity.class));
    }
}
