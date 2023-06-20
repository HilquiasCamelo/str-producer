package com.hilquiascamelo.strproducer.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Entity
@Data
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private double price;
    private String manufacturer;
    private String description;
    private int stock;

    @ElementCollection
    private List<String> categories;

    private boolean available;

    @ElementCollection
    @MapKeyColumn(name = "feature_key")
    @Column(name = "feature_value")
    private Map<String, String> features;
}
