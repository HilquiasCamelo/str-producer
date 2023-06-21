package com.hilquiascamelo.strproducer.services.impl;

import com.hilquiascamelo.strproducer.exceptions.ExceptionUtils;
import com.hilquiascamelo.strproducer.model.LogEntity;
import com.hilquiascamelo.strproducer.model.Product;
import com.hilquiascamelo.strproducer.repository.LogRepository;
import com.hilquiascamelo.strproducer.services.ObjectSendProducer;
import com.hilquiascamelo.strproducer.util.HasDateField;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
@RequiredArgsConstructor
class ObjectSendProducerImplTest {
    @Mock
    private KafkaTemplate<String, Object> kafkaTemplate;
    @Mock
    private ListenableFuture<SendResult<String, Object>> future;
    private ObjectSendProducer objectSendProducer;

    private static final int MAX_RETRY_ATTEMPTS = 3;
    @Mock
    private LogRepository logRepositoryMock;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        ExceptionUtils.setLogRepository(logRepositoryMock);
        objectSendProducer = new ObjectSendProducerImpl(kafkaTemplate);
    }

    @Test
    void sendTest_SuccessfulSend() throws ExecutionException, InterruptedException {
        // Mock the necessary objects
        Object objectToSend = createObjectToSend();

        // Mock the behavior of KafkaTemplate and ListenableFuture
        when(kafkaTemplate.send(anyString(), any(Object.class))).thenReturn(future);
        when(future.get()).thenReturn(mock(SendResult.class));

        // Call the send method
        objectSendProducer.send(objectToSend);

        // Verify that KafkaTemplate and ListenableFuture methods were called
        verify(kafkaTemplate).send(anyString(), any(Object.class));
        verify(future).addCallback(any(), any());
        verify(future).get();
    }

    @Test
    void sendTest4() {
        ListenableFuture<SendResult<String, Object>> future = mock(ListenableFuture.class);
        when(kafkaTemplate.send(anyString(), any(Object.class))).thenReturn(future);
        assertDoesNotThrow(() -> objectSendProducer.send("Object"));
    }

    @Test
    @SneakyThrows
    void sendTest_RetryOnError(){
        // Mock the necessary objects
        Object objectToSend = createObjectToSend();
        assertThrows(RuntimeException.class, () -> objectSendProducer.send(objectToSend));
    }

    private Object createObjectToSend() {
        // Create and return the object to send
        Product product = new Product();
        product.setId(123);
        product.setName("Example Product");
        product.setPrice(42.0);
        product.setManufacturer("Example Manufacturer");
        product.setDescription("Example Description");
        product.setStock(10);
        product.setCategories(Arrays.asList("Category1", "Category2"));
        product.setAvailable(true);
        product.setFeatures(Collections.singletonMap("FeatureKey", "FeatureValue"));

        if (product instanceof HasDateField) {
            HasDateField hasDateField = (HasDateField) product;
            hasDateField.setDate(LocalDateTime.parse(LocalDateTime.now()
                    .format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)));
        }

        return product;
    }
}
