package com.hilquiascamelo.strproducer.model;

import lombok.Getter;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Getter
@RequiredArgsConstructor
public class ObjectTextModel implements Serializable {
    private String name;
    private int age;
    private String occupation;
    private String address;

    @Override
    public String toString ( )
        {
            return "ObjectTextModel{" +
                   "name='" +
                   name +
                   '\'' +
                   ", age=" +
                   age +
                   ", occupation='" +
                   occupation +
                   '\'' +
                   ", address='" +
                   address +
                   '\'' +
                   '}';
        }
}
