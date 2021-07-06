package com.onnovacion.onnovacion.service.impl;

import com.onnovacion.onnovacion.dao.ClienteJuridicoDao;
import com.onnovacion.onnovacion.dto.ResponseDto;
import com.onnovacion.onnovacion.entity.ClienteJuridicoEntity;
import com.onnovacion.onnovacion.exception.BadRequestException;
import com.onnovacion.onnovacion.service.IClienteJuridicoService;
import com.onnovacion.onnovacion.service.IClienteNaturalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteJuridicoServiceImpl implements IClienteJuridicoService {

    @Autowired
    private ClienteJuridicoDao clienteJuridicoDao;

    @Autowired
    private IClienteNaturalService clienteNaturalService;

    @Override
    public List<ClienteJuridicoEntity> getAll() {
        return clienteJuridicoDao.findAll();
    }

    @Override
    public ResponseDto findById(Integer id) {
        return new ResponseDto(true, "Consulta exitosa.", clienteJuridicoDao.findById(id));
    }

    @Override
    public Optional<ClienteJuridicoEntity> findByRut(String rut) {
        return clienteJuridicoDao.findByRut(rut);
    }

    @Override
    public ResponseDto save(ClienteJuridicoEntity clienteJuridico) {
        if (clienteJuridicoDao.findByRut(clienteJuridico.getRut()).isPresent() ||
                clienteNaturalService.findByRut(clienteJuridico.getRut()).isPresent()) {
            throw new BadRequestException("Registro rechazado, el RUT no puede ser duplicado.");
        }
        return new ResponseDto(true, "Registro exitoso.",
                clienteJuridicoDao.save(clienteJuridico));
    }

    @Override
    public ResponseDto update(ClienteJuridicoEntity clienteJuridico) {
        return new ResponseDto(true, "Registro actualizado.",
                clienteJuridicoDao.save(clienteJuridico));
    }

    @Override
    public ResponseDto deleteById(Integer id) {
        clienteJuridicoDao.deleteById(id);
        return new ResponseDto(true, "Registro borrado.", null);
    }
}
