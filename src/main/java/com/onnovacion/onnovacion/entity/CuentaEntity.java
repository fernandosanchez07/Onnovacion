package com.onnovacion.onnovacion.entity;

import lombok.Data;

import javax.persistence.CascadeType;
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
@Table(name = "CUENTA")
public class CuentaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    @Column(name = "MONEDA")
    private String moneda;

    @Column(name = "SALDO")
    private int saldo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_CLI_NATURAL" )
    private ClienteNaturalEntity clienteNatural;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_CLI_JURIDICO")
    private ClienteJuridicoEntity clienteJuridico;

    @Column(name = "MOVIMIENTO")
    private Boolean movimiento;

}
