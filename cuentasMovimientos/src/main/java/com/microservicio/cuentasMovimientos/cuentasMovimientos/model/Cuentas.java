package com.microservicio.cuentasMovimientos.cuentasMovimientos.model;

import com.microservicio.cuentasMovimientos.cuentasMovimientos.Enum.TiposCuentasEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "CUENTAS")
public class Cuentas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cuentaId;

    @Column(name = "NUMERO_CUENTA")
    private String numeroCuenta;

    @Enumerated(EnumType.STRING)
    @Column(name = "TIPO")
    private TiposCuentasEnum tipo;

    @Column(name = "SALDO_INICIAL")
    private Float saldoInicial;

    @Column(name = "ESTADO")
    private Boolean estado;

    @Column(name = "CLIENTE_ID")
    private Long clienteId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ENTIDAD_ID")
    private Entidades entidad;


    @OneToMany(mappedBy = "cuentas", fetch = FetchType.LAZY)
    private List<Movimientos> movimientos = new ArrayList<>();


    /**
     *
     */
    private static final long serialVersionUID = 1L;


}
