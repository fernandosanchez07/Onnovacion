package com.onnovacion.onnovacion.validator;

import com.onnovacion.onnovacion.entity.CuentaEntity;
import com.onnovacion.onnovacion.exception.BadRequestException;
import com.onnovacion.onnovacion.type.TipoMoneda;
import org.springframework.stereotype.Component;

@Component
public class MovimientoValidator {

    public int retiroValidator(CuentaEntity cuentaEntity, int saldoMovimiento) {
        if (saldoMovimiento < 0) {
            throw new BadRequestException("Retiro rechazado, el monto a retirar supera el saldo disponible.");
        }
        return saldoMovimiento;
    }

    public int depositoValidator(CuentaEntity cuentaEntity, int saldoMovimiento) {

        if (cuentaEntity.getMoneda().equals(TipoMoneda.PESO_COLOMBIANO.getValue())) {
            if (saldoMovimiento > 1000000) {
                throw new BadRequestException("Deposito rechazdo, el deposito supera el saldo permitido.");
            }
        }
        else if (cuentaEntity.getMoneda().equals(TipoMoneda.DOLAR.getValue())) {
            if (saldoMovimiento > 300) {
                throw new BadRequestException("Deposito rechazdo, el deposito supera el saldo permitido.");
            }
        }
        else if (cuentaEntity.getMoneda().equals(TipoMoneda.EURO.getValue())) {
            if (saldoMovimiento > 150) {
                throw new BadRequestException("Deposito rechazdo, el deposito supera el saldo permitido.");
            }
        }
        return saldoMovimiento;
    }

}
