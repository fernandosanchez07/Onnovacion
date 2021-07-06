package com.onnovacion.onnovacion.dto;

import com.onnovacion.onnovacion.entity.CuentaEntity;
import com.onnovacion.onnovacion.type.TipoMovimiento;
import lombok.Data;

@Data
public class MovimientoDto {

    private int id;

    private TipoMovimiento tipoMovimiento;

    private int valorMovimiento;

    private int idCuenta;

    private CuentaEntity cuentaEntity;
}
