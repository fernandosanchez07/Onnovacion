package com.onnovacion.onnovacion.dao;

import com.onnovacion.onnovacion.entity.ClienteNaturalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteNaturalDao extends JpaRepository<ClienteNaturalEntity, Integer> {

    Optional<ClienteNaturalEntity> findByRut(String rut);

}
