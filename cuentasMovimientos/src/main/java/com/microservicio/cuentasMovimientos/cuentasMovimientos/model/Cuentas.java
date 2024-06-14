package com.microservicio.cuentasMovimientos.cuentasMovimientos.model;

import com.microservicio.cuentasMovimientos.cuentasMovimientos.Enum.TiposCuentasEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "CUENTAS")
public class Cuentas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long cuentasId;

    @Column(name = "NUMERO_CUENTA")
    private String numeroCuenta;

    @Enumerated(EnumType.STRING)
    @Column(name = "TIPO")
    private TiposCuentasEnum tipo;

    @Column(name = "SALDO_INICIAL")
    private Float saldoInicial;

    @Column(name = "ESTADO")
    private Boolean estado;

    @ManyToOne
    @JoinColumn(name = "ENTIDAD_ID")
    private Entidades entidad;


    @OneToMany(mappedBy = "cuentas")
    private List<Movimientos> movimientos = new ArrayList<>();


    /**
     *
     */
    private static final long serialVersionUID = 1L;


}
