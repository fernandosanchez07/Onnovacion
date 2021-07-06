package com.onnovacion.onnovacion.dao;

import com.onnovacion.onnovacion.entity.MovimientoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovimientoDao extends JpaRepository<MovimientoEntity, Integer> {

    Optional<MovimientoEntity> findAllByCuentaEntity(Integer id);

}
