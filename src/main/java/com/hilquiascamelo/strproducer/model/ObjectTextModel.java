package com.hilquiascamelo.strproducer.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class ObjectTextModel implements Serializable {
    private String name;
    private int age;
    private String occupation;
    private String address;

}
