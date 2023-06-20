package com.hilquiascamelo.strproducer.services;

import com.hilquiascamelo.strproducer.model.Address;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AddressService {

   public List findAll();

   List<Address> save ( List < Address > addresses );

   Address findById ( Long id );
}
