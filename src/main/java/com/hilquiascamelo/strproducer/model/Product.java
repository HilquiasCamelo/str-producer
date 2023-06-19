package com.hilquiascamelo.strproducer.model;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class Product {
    private int id;
    private String name;
    private double price;
    private String manufacturer;
    private String description;
    private int stock;
    private List<String> categories;
    private boolean available;
    private Map<String, String> features;
}
