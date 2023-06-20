package com.hilquiascamelo.strproducer.repository;

import com.hilquiascamelo.strproducer.model.LogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface LogRepository extends JpaRepository<LogEntity, Long> {
    // Nenhum método personalizado é necessário aqui
}