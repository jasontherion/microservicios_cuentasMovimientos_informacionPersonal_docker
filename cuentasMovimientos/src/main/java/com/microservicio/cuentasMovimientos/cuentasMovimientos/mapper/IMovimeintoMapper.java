package com.microservicio.cuentasMovimientos.cuentasMovimientos.mapper;

import com.microservicio.cuentasMovimientos.cuentasMovimientos.dto.CuentaDTO;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.dto.EntidadDTO;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.dto.MovimientoDTO;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.model.Movimientos;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface IMovimeintoMapper {

    Movimientos movimientosDtoAMovimientos(MovimientoDTO movimientoDTO);

    default MovimientoDTO movimientosAMovimientosDto(Movimientos movimientos){

        return MovimientoDTO.builder()
                .movimentoId(movimientos.getMovimentoId())
                .fecha(movimientos.getFecha())
                .tipoMovimiento(String.valueOf(movimientos.getTipoMovimiento()))
                .valor(movimientos.getValor())
                .saldo(movimientos.getSaldo())
                .entidad(EntidadDTO.builder()
                        .entidadId(movimientos.getEntidad().getEntidadId())
                        .nombre(movimientos.getEntidad().getNombre())
                        .build())
                .cuenta(CuentaDTO.builder()
                        .cuentaId(movimientos.getCuentas().getCuentaId())
                        .numeroCuenta(movimientos.getCuentas().getNumeroCuenta())
                        .tipo(String.valueOf(movimientos.getCuentas().getTipo()))
                        .saldoInicial(movimientos.getCuentas().getSaldoInicial())
                        .estado(movimientos.getCuentas().getEstado())
                        .build())
                .build();
    }

    void actualizarMovimientos(MovimientoDTO movimientoDTO, @MappingTarget Movimientos movimientos);

    List<MovimientoDTO> listaMovimientosAListaMovimientosDto(List<Movimientos> movimientos);
}
