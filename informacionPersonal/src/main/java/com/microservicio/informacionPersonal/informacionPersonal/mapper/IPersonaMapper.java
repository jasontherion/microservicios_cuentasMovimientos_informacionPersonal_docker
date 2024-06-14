package com.microservicio.informacionPersonal.informacionPersonal.mapper;


import com.microservicio.informacionPersonal.informacionPersonal.dto.PersonasDTO;
import com.microservicio.informacionPersonal.informacionPersonal.model.Personas;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface IPersonaMapper {

    @Mapping(target ="personaId",ignore = true)
    Personas personasDtoAPersonas(PersonasDTO personasDto);

    List<PersonasDTO> listaPersonasAListaPersonasDto(List<Personas> personas);

    PersonasDTO personasAPersonasDto(Personas personas);

    void actualizarPersonas(PersonasDTO personasDto, @MappingTarget Personas personas);


}
