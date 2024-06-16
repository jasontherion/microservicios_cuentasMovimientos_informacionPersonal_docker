package com.microservicio.cuentasMovimientos.cuentasMovimientos.mapper;

import com.microservicio.cuentasMovimientos.cuentasMovimientos.Enum.TiposCuentasEnum;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.dto.CuentaCreacionDTO;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.dto.CuentaDTO;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.dto.EntidadDTO;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.dto.MovimientoDTO;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.model.Cuentas;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ICuentaMapper {

//    @Mapping(target ="personas",ignore = true)
    Cuentas cuentasDtoACuenta(CuentaDTO cuentaDTO);


    @Mapping(target = "movimientos", ignore = true)
    @Mapping(target = "entidad.entidadId", source = "entidadId")
    Cuentas cuentasDtoACuentaCreacion(CuentaCreacionDTO creacionDTO);

    default CuentaDTO cuentasACuentaDto(Cuentas cuentas){
        return CuentaDTO.builder()
                .cuentaId(cuentas.getCuentaId())
                .numeroCuenta(cuentas.getNumeroCuenta())
                .tipo(cuentas.getTipo().toString())
                .saldoInicial(cuentas.getSaldoInicial())
                .estado(cuentas.getEstado())
                .entidad(EntidadDTO.builder()
                        .entidadId(cuentas.getEntidad().getEntidadId())
                        .nombre(cuentas.getEntidad().getNombre())
                        .build())
                .movimientos(cuentas.getMovimientos().stream().map(m->{
                    MovimientoDTO dto = new MovimientoDTO();
                    dto.setMovimentoId(m.getMovimentoId());
                    dto.setFecha(m.getFecha());
                    dto.setTipoMovimiento(String.valueOf(m.getTipoMovimiento()));
                    dto.setValor(m.getValor());
                    dto.setSaldo(m.getSaldo());

                    return dto;
                }).collect(Collectors.toList()))
                .clientes(null)
                .build();
    }
    @Mapping(target = "personas",ignore = true)
    @Mapping(target = "entidad",ignore = true)
    default void actualizarCuenta(CuentaDTO cuentaDTO, @MappingTarget Cuentas cuentas){
        cuentas.setNumeroCuenta(cuentaDTO.getNumeroCuenta());
        cuentas.setTipo(TiposCuentasEnum.valueOf(cuentaDTO.getTipo()));
        cuentas.setSaldoInicial(cuentaDTO.getSaldoInicial());
        cuentas.setEstado(cuentaDTO.getEstado());

    }

   default List<CuentaDTO> listaCuentasAListaCuentasDto(List<Cuentas> cuentas){

        return cuentas.stream()
                .map(cuenta -> {
                    CuentaDTO dto = new CuentaDTO();
                    dto.setCuentaId(cuenta.getCuentaId());
                    dto.setNumeroCuenta(cuenta.getNumeroCuenta());
                    dto.setTipo(cuenta.getTipo().toString());
                    dto.setEntidad(EntidadDTO.builder().entidadId(cuenta.getEntidad().getEntidadId()).build());
                    return dto;
                })
                .collect(Collectors.toList());
    }
}
