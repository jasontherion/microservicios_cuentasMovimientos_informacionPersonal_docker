package com.microservicio.informacionPersonal.informacionPersonal.model;


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
@Table(name = "PERSONAS")
public class Personas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PERSONA_ID")
    private Long personaId;

    @Column(name = "NOMBRE",nullable = false)
    private String nombre;

    @Column(name = "GENERO",nullable = false)
    private String genero;

    @Column(name = "EDAD",nullable = false)
    private Integer edad;

    @Column(name = "IDENTIFICACION",nullable = false)
    private String identificacion;

    @Column(name = "DIRECCION",nullable = false)
    private String direccion;

    @Column(name = "TELEFONO",nullable = false)
    private String telefono;



    @OneToMany(mappedBy = "personas")
    @ToString.Exclude
    private List<Clientes> clientes = new ArrayList<>();




    /**
     *
     */
    private static final long serialVersionUID = 1L;
}
