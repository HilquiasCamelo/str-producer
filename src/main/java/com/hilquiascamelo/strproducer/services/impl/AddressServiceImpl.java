package com.hilquiascamelo.strproducer.services.impl;

import com.hilquiascamelo.strproducer.model.Address;
import com.hilquiascamelo.strproducer.repository.AddressRepository;
import com.hilquiascamelo.strproducer.services.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository AddressRepository;

    @Override
    public List<Address> findAll() {
        return AddressRepository.findAll();
    }

    @Override
    public List<Address> save ( List < Address > addresses ) {
        return AddressRepository.saveAll(addresses);
    }

    @Override
    public Address findById(Long id) {
        return AddressRepository.findById(id).get();
    }
}
