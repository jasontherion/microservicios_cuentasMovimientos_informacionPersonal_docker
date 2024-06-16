package com.microservicio.cuentasMovimientos.cuentasMovimientos.mapper;

import com.microservicio.cuentasMovimientos.cuentasMovimientos.dto.EntidadDTO;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.model.Entidades;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface IEntidadMapper {

    Entidades entidadesDtoAEntidades(EntidadDTO entidadDTO);

    List<Entidades> listaEntidadesDtoAListaEntidades(List<EntidadDTO> entidadDTO);

    EntidadDTO entidadesAEntidadesDto(Entidades entidades);

    List<EntidadDTO> listaEntidadesAListaEntidadesDto(List<Entidades> entidades);

    @Mapping(target = "entidadId" , ignore = true)
    @Mapping(target = "movimientos" , ignore = true)
    @Mapping(target = "cuentas", ignore = true)
    void actualizarEntidades(EntidadDTO entidadDTO, @MappingTarget Entidades entidades);


}
