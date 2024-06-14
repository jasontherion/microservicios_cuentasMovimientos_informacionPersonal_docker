package com.microservicio.cuentasMovimientos.cuentasMovimientos.mapper;

import com.microservicio.cuentasMovimientos.cuentasMovimientos.dto.MovimientoDTO;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.model.Movimientos;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface IMovimeintoMapper {

    Movimientos movimientosDtoAMovimientos(MovimientoDTO movimientoDTO);

    MovimientoDTO movimientosAMovimientosDto(Movimientos movimientos);

    void actualizarMovimientos(MovimientoDTO movimientoDTO, @MappingTarget Movimientos movimientos);
}
