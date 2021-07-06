package com.onnovacion.onnovacion.service;

import com.onnovacion.onnovacion.dto.ResponseDto;
import com.onnovacion.onnovacion.entity.CuentaEntity;
import javassist.NotFoundException;

import java.util.List;
import java.util.Optional;

public interface ICuentaService {

    List<CuentaEntity> getAll();

    Optional<CuentaEntity> findById(Integer id);

    ResponseDto save(CuentaEntity cuenta) throws NotFoundException;

    ResponseDto update(CuentaEntity cuenta);

    ResponseDto deleteById(Integer id);
}
