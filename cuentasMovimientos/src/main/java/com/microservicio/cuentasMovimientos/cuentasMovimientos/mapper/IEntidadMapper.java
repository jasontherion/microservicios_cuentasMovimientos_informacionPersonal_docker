package com.microservicio.cuentasMovimientos.cuentasMovimientos.mapper;

import com.microservicio.cuentasMovimientos.cuentasMovimientos.dto.EntidadDTO;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.model.Entidades;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface IEntidadMapper {

    Entidades entidadesAEntidadesDto(EntidadDTO entidadDTO);

    EntidadDTO entidadesAEntidadesDto(Entidades entidades);

    void actualizarEntidades(EntidadDTO entidadDTO, @MappingTarget Entidades entidades);


}
