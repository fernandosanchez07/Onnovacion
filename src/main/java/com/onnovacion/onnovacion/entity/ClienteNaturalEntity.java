package com.onnovacion.onnovacion.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "CLIENTE_NATURAL")
public class ClienteNaturalEntity {

    @Column(name = "NOMBRE", length = 80)
    private String nombre;

    @Column(name = "APELLIDO", length = 250)
    private String apellido;


    @Column(name = "TIPO_DOCUMENTO")
    private String tipoDocumento;

    @Id
    @Column(name = "NUMERO_DOCUMENTO", nullable = false)
    private String numeroDocumento;

    @Column(name = "RUT")
    private String rut;
}
