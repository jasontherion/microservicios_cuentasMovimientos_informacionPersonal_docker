package com.microservicio.informacionPersonal.informacionPersonal.mapper;


import com.microservicio.informacionPersonal.informacionPersonal.dto.ClienteContenedorDTO;
import com.microservicio.informacionPersonal.informacionPersonal.model.Clientes;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface IClientePersonaMapper {

    @Mapping(target = "clienteId", ignore = true) // Ignoramos el ID al crear un nuevo cliente
    @Mapping(source = "clienteContenedorDTO.personasDto", target = "personas")
    Clientes clienteContenedorDTOAClientes(ClienteContenedorDTO clienteContenedorDTO);

    @Mapping(target = "clienteId", ignore = true) // Ignoramos el ID al crear un nuevo cliente
    @Mapping(source = "clienteContenedorDTO.personasDto", target = "personas")
    void actualizarClientePersonaDTO(ClienteContenedorDTO clienteContenedorDTO, @MappingTarget Clientes clientes);
}
