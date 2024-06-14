package com.microservicio.informacionPersonal.informacionPersonal.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "CLIENTES")
public class Clientes  implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "CLIENTE_ID")
    private Long clienteId;

    @Column(name = "CONTRASENIA")
    private String contrasenia;

    @Column(name = "ESTADO")
    private Boolean estado;

    @ManyToOne
    @JoinColumn(name = "PERSONA_ID")
    private Personas personas;

    /**
     *
     */
    private static final long serialVersionUID = 1L;

}
