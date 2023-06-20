package com.hilquiascamelo.strproducer.repository;

import com.hilquiascamelo.strproducer.model.Address;
import com.hilquiascamelo.strproducer.model.LogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional (readOnly = true)
public interface AddressRepository extends JpaRepository < Address, Long> {
}
