package com.onnovacion.onnovacion.controller;

import com.onnovacion.onnovacion.dto.ResponseDto;
import com.onnovacion.onnovacion.entity.CuentaEntity;
import com.onnovacion.onnovacion.service.ICuentaService;
import io.swagger.annotations.ApiOperation;
import javassist.NotFoundException;
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
import java.util.Optional;

@RestController
@RequestMapping("/cuenta")
public class CuentaController {


    @Autowired
    private ICuentaService cuentaService;

    @ApiOperation(value = "Permite guardar una cuenta.")
    @PostMapping("/save")
    public ResponseDto save(@RequestBody CuentaEntity cuenta) throws NotFoundException {
        return cuentaService.save(cuenta);
    }

    @ApiOperation(value = "Permite listar todas las cuentas.")
    @GetMapping("/getAll")
    public List<CuentaEntity> getAll() {
        return cuentaService.getAll();
    }

    @ApiOperation(value = "Permite listar buscar una cuenta por id.")
    @GetMapping("/find/{id}")
    public Optional<CuentaEntity> findById(@PathVariable Integer id) {
        return cuentaService.findById(id);
    }

    @ApiOperation(value = "Permite listar permite actualizar una cuenta.")
    @PutMapping("/update")
    public ResponseDto update(@RequestBody CuentaEntity cuenta) {
        return cuentaService.update(cuenta);
    }

    @ApiOperation(value = "Permite eliminar una cuenta.")
    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable Integer id) {
        return cuentaService.deleteById(id);
    }

}
