package com.onnovacion.onnovacion.service.impl;

import com.onnovacion.onnovacion.dao.MovimientoDao;
import com.onnovacion.onnovacion.dto.MovimientoDto;
import com.onnovacion.onnovacion.dto.ResponseDto;
import com.onnovacion.onnovacion.entity.CuentaEntity;
import com.onnovacion.onnovacion.entity.MovimientoEntity;
import com.onnovacion.onnovacion.service.IMovimientoService;
import com.onnovacion.onnovacion.type.TipoMovimiento;
import com.onnovacion.onnovacion.validator.MovimientoValidator;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovimientoServiceImpl implements IMovimientoService {

    @Autowired
    private MovimientoDao movimientoDao;

    @Autowired
    private CuentaServiceImpl cuentaService;

    @Autowired
    private MovimientoValidator movimientoValidator;


    @Override
    public List<MovimientoEntity> getAll() {
        return movimientoDao.findAll();
    }

    @Override
    public Optional<MovimientoEntity> findAllByCuentaEntity(Integer idCuenta) {
        return movimientoDao.findAllByCuentaEntity(idCuenta);
    }


    @Override
    public ResponseDto findById(Integer id) {
        return new ResponseDto(true, "Consulta exitosa.", movimientoDao.findById(id));
    }

    @Override
    public ResponseDto save(MovimientoDto movimientoDto) throws NotFoundException {
        MovimientoEntity movimientoEntity = new MovimientoEntity();

        if (movimientoDto.getCuentaEntity() != null) {
            movimientoEntity.setCuentaEntity(movimientoDto.getCuentaEntity());
            movimientoEntity.setTipoMovimiento(movimientoDto.getTipoMovimiento().getValue());
            movimientoEntity.setValorMovimiento(movimientoDto.getValorMovimiento());
            movimientoDao.save(movimientoEntity);
            return new ResponseDto(true, "Registro exitoso.", movimientoDao.save(movimientoEntity));
        }

        Optional<CuentaEntity> consultaCuenta = cuentaService.findById(movimientoDto.getIdCuenta());
        if (!consultaCuenta.isPresent()) {
            throw new NotFoundException("Cuenta no encontrada.");
        }

        int saldoMovimiento;
        if (movimientoDto.getTipoMovimiento().equals(TipoMovimiento.DEPOSITO)) {
            saldoMovimiento = consultaCuenta.get().getSaldo() + movimientoDto.getValorMovimiento();
            consultaCuenta.get().setSaldo(movimientoValidator.depositoValidator(consultaCuenta.get(), saldoMovimiento));
        }
        else if (movimientoDto.getTipoMovimiento().equals(TipoMovimiento.RETIRO)) {
            saldoMovimiento = consultaCuenta.get().getSaldo() - movimientoDto.getValorMovimiento();
            consultaCuenta.get().setSaldo(movimientoValidator.retiroValidator(consultaCuenta.get(), saldoMovimiento));
        }

        movimientoEntity.setCuentaEntity(consultaCuenta.get());
        movimientoEntity.setTipoMovimiento(movimientoDto.getTipoMovimiento().getValue());
        movimientoEntity.setValorMovimiento(movimientoDto.getValorMovimiento());

        consultaCuenta.get().setMovimiento(true);
        cuentaService.update(consultaCuenta.get());
        return new ResponseDto(true, "Registro exitoso.", movimientoDao.save(movimientoEntity));

    }

    @Override
    public ResponseDto update(MovimientoEntity movimiento) {
        return new ResponseDto(true, "Accion no permitida.", null);
    }

    @Override
    public ResponseDto deleteById(Integer id) {
        return new ResponseDto(true, "Accion no permitida.", null);
    }

}
