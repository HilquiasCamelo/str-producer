package com.hilquiascamelo.strproducer.model;

import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Getter
public class Order {
    private String id;
    private LocalDateTime date;
    private Customer customer;
    private List<OrderItem> items;
    private double total;
    private String status;
}
