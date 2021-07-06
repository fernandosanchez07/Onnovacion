package com.onnovacion.onnovacion.service.impl;

import com.onnovacion.onnovacion.dao.ClienteNaturalDao;
import com.onnovacion.onnovacion.dto.ResponseDto;
import com.onnovacion.onnovacion.entity.ClienteNaturalEntity;
import com.onnovacion.onnovacion.exception.BadRequestException;
import com.onnovacion.onnovacion.service.IClienteJuridicoService;
import com.onnovacion.onnovacion.service.IClienteNaturalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteNaturalServiceImpl implements IClienteNaturalService {

    @Autowired
    private ClienteNaturalDao clienteNaturalDao;

    @Autowired
    private IClienteJuridicoService clienteJuridicoService;

    @Override
    public List<ClienteNaturalEntity> getAll() {
        return clienteNaturalDao.findAll();
    }

    @Override
    public ResponseDto findById(Integer id) {
        return new ResponseDto(true, "Consulta exitosa.", clienteNaturalDao.findById(id));
    }

    @Override
    public Optional<ClienteNaturalEntity> findByRut(String rut) {
        return clienteNaturalDao.findByRut(rut);
    }

    @Override
    public ResponseDto save(ClienteNaturalEntity clienteNatural) {
        if (clienteNaturalDao.findByRut(clienteNatural.getRut()).isPresent() ||
                clienteJuridicoService.findByRut(clienteNatural.getRut()).isPresent()) {
            throw new BadRequestException("Registro rechazado, el RUT no puede ser duplicado.");
        }
        return new ResponseDto(true, "Registro exitoso.",
                clienteNaturalDao.save(clienteNatural));
    }

    @Override
    public ResponseDto update(ClienteNaturalEntity clienteNatural) {
        return new ResponseDto(true, "Registro actualizado.",
                clienteNaturalDao.save(clienteNatural));
    }

    @Override
    public ResponseDto deleteById(Integer id) {
        clienteNaturalDao.deleteById(id);
        return new ResponseDto(true, "Registro borrado.", null);
    }

}
