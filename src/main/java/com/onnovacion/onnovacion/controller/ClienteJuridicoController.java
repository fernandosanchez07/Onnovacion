package com.onnovacion.onnovacion.controller;

import com.onnovacion.onnovacion.dto.ResponseDto;
import com.onnovacion.onnovacion.entity.ClienteJuridicoEntity;
import com.onnovacion.onnovacion.service.IClienteJuridicoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cliente_juridico")
public class ClienteJuridicoController {

    @Autowired
    private IClienteJuridicoService clienteJuridicoService;

    @ApiOperation(value = "Permite guardar un cliente juridico.")
    @PostMapping("/save")
    public ResponseDto save(@RequestBody ClienteJuridicoEntity clienteJuridico) {
        return clienteJuridicoService.save(clienteJuridico);
    }

    @ApiOperation(value = "Permite listar todos los clientes juridicos.")
    @GetMapping("/getAll")
    public List<ClienteJuridicoEntity> getAll() {
        return clienteJuridicoService.getAll();
    }

    @ApiOperation(value = "Permite listar todos los clientes juridicos.")
    @GetMapping("/find/{id}")
    public ResponseDto findById(@PathVariable Integer id) {
        return clienteJuridicoService.findById(id);
    }

    @ApiOperation(value = "Permite listar todos los clientes juridicos.")
    @PutMapping("/update")
    public ResponseDto update(@RequestBody ClienteJuridicoEntity clienteJuridicoEntity) {
        return clienteJuridicoService.update(clienteJuridicoEntity);
    }

    @ApiOperation(value = "Permite listar todos los clientes juridicos.")
    @DeleteMapping("/delete/{id}")
    public ResponseDto update(@PathVariable Integer id) {
        return clienteJuridicoService.deleteById(id);
    }
}
