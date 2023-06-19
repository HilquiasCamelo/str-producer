package com.hilquiascamelo.strproducer.model;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class OrderItem {
    private String productId;
    private String productName;
    private int quantity;
    private double price;
}
