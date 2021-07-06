package com.onnovacion.onnovacion.service;

import com.onnovacion.onnovacion.dto.ResponseDto;
import com.onnovacion.onnovacion.entity.ClienteNaturalEntity;

import java.util.List;
import java.util.Optional;

public interface IClienteNaturalService {

    List<ClienteNaturalEntity> getAll();

    ResponseDto findById(Integer id);

    Optional<ClienteNaturalEntity> findByRut(String rut);

    ResponseDto save(ClienteNaturalEntity clienteNatural);

    ResponseDto update(ClienteNaturalEntity clienteNatural);

    ResponseDto deleteById(Integer id);

}
