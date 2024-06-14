package com.microservicio.cuentasMovimientos.cuentasMovimientos.mapper;

import com.microservicio.cuentasMovimientos.cuentasMovimientos.dto.CuentaDTO;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.dto.MovimientoDTO;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.model.Cuentas;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ICuentaMapper {

    Cuentas cuentasDtoACuenta(CuentaDTO cuentaDTO);

    CuentaDTO cuentasACuentaDto(Cuentas cuentas);

    void actualizarCuenta(MovimientoDTO movimientoDTO, @MappingTarget Cuentas cuentas);
}
