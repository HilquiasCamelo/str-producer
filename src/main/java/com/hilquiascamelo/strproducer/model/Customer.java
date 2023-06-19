package com.hilquiascamelo.strproducer.model;

import lombok.Data;
import org.apache.tomcat.jni.Address;

import java.util.List;

@Data
public class Customer {
    private int id;
    private String name;
    private int age;
    private String email;
    private String phone;
    private Address address;
    private List<Order> orders;
}
