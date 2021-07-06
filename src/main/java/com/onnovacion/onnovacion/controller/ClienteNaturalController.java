package com.onnovacion.onnovacion.controller;

import com.onnovacion.onnovacion.dto.ResponseDto;
import com.onnovacion.onnovacion.entity.ClienteNaturalEntity;
import com.onnovacion.onnovacion.service.IClienteNaturalService;
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
@RequestMapping("/cliente_natural")
public class ClienteNaturalController {

    @Autowired
    private IClienteNaturalService clienteNaturalService;

    @ApiOperation(value = "Permite guardar un cliente.")
    @PostMapping("/save")
    public ResponseDto save(@RequestBody ClienteNaturalEntity clienteNatural) {
        return clienteNaturalService.save(clienteNatural);
    }

    @ApiOperation(value = "Permite listar todos los clientes.")
    @GetMapping("/getAll")
    public List<ClienteNaturalEntity> getAll() {
        return clienteNaturalService.getAll();
    }

    @ApiOperation(value = "Permite listar todos los clientes naturales.")
    @GetMapping("/find/{id}")
    public ResponseDto findById(@PathVariable Integer id) {
        return clienteNaturalService.findById(id);
    }

    @ApiOperation(value = "Permite actualizar un cliente.")
    @PutMapping("/update")
    public ResponseDto update(@RequestBody ClienteNaturalEntity clienteNatural) {
        return clienteNaturalService.update(clienteNatural);
    }

    @ApiOperation(value = "Permite eliminar un cliente por id.")
    @DeleteMapping("/delete/{id}")
    public ResponseDto update(@PathVariable Integer id) {
        return clienteNaturalService.deleteById(id);
    }

}
