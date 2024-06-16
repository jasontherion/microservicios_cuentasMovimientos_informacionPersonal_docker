package com.microservicio.cuentasMovimientos.cuentasMovimientos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "ENTIDADES")
public class Entidades implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ENTIDAD_ID")
    private Long entidadId;

    @Column(name = "NOMBRE")
    private String nombre;

    @OneToMany(mappedBy ="entidad")
    @ToString.Exclude
    @JsonIgnore
    private List<Cuentas> cuentas = new ArrayList<>();

    @OneToMany(mappedBy ="entidad")
    private List<Movimientos> movimientos = new ArrayList<>();

    /**
     *
     */
    private static final long serialVersionUID = 1L;

}
