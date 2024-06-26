package com.microservicio.cuentasMovimientos.cuentasMovimientos.model;


import com.microservicio.cuentasMovimientos.cuentasMovimientos.Enum.TipoMovimientoEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "MOVIMIENTOS")
public class Movimientos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movimentoId;

    @Column(name = "FECHA")
    private LocalDate fecha;

    @Enumerated(EnumType.STRING)
    @Column(name = "TIPO_MOVIMIENTO")
    private TipoMovimientoEnum tipoMovimiento;

    @Column(name = "VALOR")
    private Float valor;

    @Column(name = "SALDO")
    private Float saldo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ENTIDAD_ID")
    private Entidades entidad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CUENTA_ID")
    private Cuentas cuentas;

    /**
     *
     */
    private static final long serialVersionUID = 1L;







}
