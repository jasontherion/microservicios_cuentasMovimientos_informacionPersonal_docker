package com.microservicio.cuentasMovimientos.cuentasMovimientos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Builder
@AllArgsConstructor
@Data
@Entity
@Table(name = "ENTIDADES")
public class Entidades implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ENTIDAD_ID")
    private Long entidadId;

    @Column(name = "NOMBRE")
    private String nombre;

    @OneToMany(mappedBy ="entidad")
    private List<Cuentas> cuentas = new ArrayList<>();

    @OneToMany(mappedBy ="entidad")
    private List<Movimientos> movimientos = new ArrayList<>();

    /**
     *
     */
    private static final long serialVersionUID = 1L;

}
