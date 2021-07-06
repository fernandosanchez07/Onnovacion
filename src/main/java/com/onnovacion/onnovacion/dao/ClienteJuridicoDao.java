package com.onnovacion.onnovacion.dao;

import com.onnovacion.onnovacion.entity.ClienteJuridicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteJuridicoDao extends JpaRepository<ClienteJuridicoEntity, Integer> {

    Optional<ClienteJuridicoEntity> findByRut(String rut);


}
