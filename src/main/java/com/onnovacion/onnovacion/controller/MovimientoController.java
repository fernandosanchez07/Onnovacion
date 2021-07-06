package com.onnovacion.onnovacion.controller;

import com.onnovacion.onnovacion.dto.MovimientoDto;
import com.onnovacion.onnovacion.dto.ResponseDto;
import com.onnovacion.onnovacion.entity.MovimientoEntity;
import com.onnovacion.onnovacion.service.IMovimientoService;
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

@RestController
@RequestMapping("/movimiento")
public class MovimientoController {

    @Autowired
    private IMovimientoService movimientoService;

    @ApiOperation(value = "Permite guardar un movimiento.")
    @PostMapping("/save")
    public ResponseDto save(@RequestBody MovimientoDto movimientoDto) throws NotFoundException {
        return movimientoService.save(movimientoDto);
    }

    @ApiOperation(value = "Permite listar todos los movimientos.")
    @GetMapping("/getAll")
    public List<MovimientoEntity> getAll() {
        return movimientoService.getAll();
    }

    @ApiOperation(value = "Permite buscar un movimiento por id.")
    @GetMapping("/find/{id}")
    public ResponseDto findById(@PathVariable Integer id) {
        return movimientoService.findById(id);
    }

    @ApiOperation(value = "Permite actualizar un movimientos.")
    @PutMapping("/update")
    public ResponseDto update(@RequestBody MovimientoEntity movimiento) {
        return movimientoService.update(movimiento);
    }

    @ApiOperation(value = "Permite eliminar un movimiento.")
    @DeleteMapping("/delete/{id}")
    public ResponseDto deleteById(@PathVariable Integer id) {
        return movimientoService.deleteById(id);
    }

}
