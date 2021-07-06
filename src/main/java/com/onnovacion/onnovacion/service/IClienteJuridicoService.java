package com.onnovacion.onnovacion.service;

import com.onnovacion.onnovacion.dto.ResponseDto;
import com.onnovacion.onnovacion.entity.ClienteJuridicoEntity;

import java.util.List;
import java.util.Optional;

public interface IClienteJuridicoService {

    List<ClienteJuridicoEntity> getAll();

    ResponseDto findById(Integer id);

    Optional<ClienteJuridicoEntity> findByRut(String rut);

    ResponseDto save(ClienteJuridicoEntity clienteJuridico);

    ResponseDto update(ClienteJuridicoEntity clienteJuridico);

    ResponseDto deleteById(Integer id);

}
