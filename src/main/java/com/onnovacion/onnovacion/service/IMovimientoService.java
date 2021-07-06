package com.onnovacion.onnovacion.service;

import com.onnovacion.onnovacion.dto.MovimientoDto;
import com.onnovacion.onnovacion.dto.ResponseDto;
import com.onnovacion.onnovacion.entity.MovimientoEntity;
import javassist.NotFoundException;

import java.util.List;
import java.util.Optional;

public interface IMovimientoService {

    List<MovimientoEntity> getAll();

    Optional<MovimientoEntity> findAllByCuentaEntity(Integer idCuenta);

    ResponseDto findById(Integer id);

    ResponseDto save(MovimientoDto movimientoDto) throws NotFoundException;

    ResponseDto update(MovimientoEntity movimiento);

    ResponseDto deleteById(Integer id);
}
