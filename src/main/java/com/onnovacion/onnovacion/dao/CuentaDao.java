package com.onnovacion.onnovacion.dao;

import com.onnovacion.onnovacion.entity.CuentaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuentaDao extends JpaRepository<CuentaEntity, Integer> {

}
