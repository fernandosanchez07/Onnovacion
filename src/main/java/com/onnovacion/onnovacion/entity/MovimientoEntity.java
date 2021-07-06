package com.onnovacion.onnovacion.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "MOVIMIENTO")
public class MovimientoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    @Column(name = "TIPO_MOVIMIENTO")
    private String tipoMovimiento;

    @Column(name = "VALOR_MOVIMIENTO")
    private int valorMovimiento;

    @ManyToOne
    @JoinColumn(name = "CUENTA")
    private CuentaEntity cuentaEntity;

}
