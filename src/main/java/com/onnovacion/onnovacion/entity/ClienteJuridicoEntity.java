package com.onnovacion.onnovacion.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
@Entity
@Table(name = "CLIENTE_JURIDICO")
public class ClienteJuridicoEntity {

    @Column(name = "NOMBRE", length = 80)
    private String nombre;

    @Column(name = "APELLIDO", length = 250)
    private String apellido;

    @Column(name = "TIPO_DOCUMENTO")
    private String tipoDocumento;

    @Id
    @Column(name = "NUMERO_DOCUMENTO", nullable = false)
    private String numeroDocumento;

    @Column(name = "FECHA_REGISTRO", nullable = false)
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy")
    private Date fechaFundacion;

    @Column(name = "RAZON_SOCIAL", length = 100)
    private String razonSocial;

    @Column(name = "RUT")
    private String rut;

}
