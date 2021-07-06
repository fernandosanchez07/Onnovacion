package com.onnovacion.onnovacion.service.impl;

import com.onnovacion.onnovacion.dao.CuentaDao;
import com.onnovacion.onnovacion.dto.MovimientoDto;
import com.onnovacion.onnovacion.dto.ResponseDto;
import com.onnovacion.onnovacion.entity.CuentaEntity;
import com.onnovacion.onnovacion.exception.BadRequestException;
import com.onnovacion.onnovacion.service.ICuentaService;
import com.onnovacion.onnovacion.service.IMovimientoService;
import com.onnovacion.onnovacion.type.TipoMovimiento;
import com.onnovacion.onnovacion.validator.MovimientoValidator;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CuentaServiceImpl implements ICuentaService {

    @Autowired
    private CuentaDao cuentaDao;

    @Autowired
    private IMovimientoService movimientoService;

    @Override
    public List<CuentaEntity> getAll() {
        return cuentaDao.findAll();
    }

    @Autowired
    private MovimientoValidator movimientoValidator;

    @Override
    public Optional<CuentaEntity> findById(Integer id) {
        return cuentaDao.findById(id);
    }

    @Override
    public ResponseDto save(CuentaEntity cuenta) throws NotFoundException {

        if (cuenta.getClienteJuridico() != null && cuenta.getClienteNatural() != null) {
            throw new BadRequestException("Error al crear cuenta, no puede tener mas de un cliente.");
        }
        else if (cuenta.getClienteJuridico() == null && cuenta.getClienteNatural() == null) {
            throw new BadRequestException("Error al crear cuenta debe tener un cliente.");
        }

        cuentaDao.save(cuenta);

        if (cuenta.getSaldo() > 0) {
            insertarMovimiento(cuenta);
        }

        return new ResponseDto(true, "Registro exitoso.", cuenta);

    }

    @Override
    public ResponseDto update(CuentaEntity cuenta) {
        return new ResponseDto(true, "Registro actualizado.", cuentaDao.save(cuenta));
    }

    @Override
    public ResponseDto deleteById(Integer id) {
        if (cuentaDao.getById(id).getMovimiento()) {
            throw new BadRequestException("No se puede eliminar la cuenta.");
        }
        cuentaDao.deleteById(id);
        return new ResponseDto(true, "Registro borrado.", null);
    }

    private void insertarMovimiento(CuentaEntity cuenta) throws NotFoundException {
        MovimientoDto movimiento = new MovimientoDto();
        movimiento.setValorMovimiento(cuenta.getSaldo());
        movimiento.setTipoMovimiento(TipoMovimiento.DEPOSITO);
        movimiento.setCuentaEntity(cuenta);
        movimientoService.save(movimiento);
    }
}
