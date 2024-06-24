package com.microservicio.informacionPersonal.informacionPersonal.mapper;

import com.microservicio.informacionPersonal.informacionPersonal.dto.ClientesDTO;
import com.microservicio.informacionPersonal.informacionPersonal.dto.PersonasDTO;
import com.microservicio.informacionPersonal.informacionPersonal.model.Clientes;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import reactor.core.publisher.Flux;

import java.util.List;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface IClienteMapper {
//    @Mapping(target ="clienteId",ignore = true)
    Clientes clientesDtoAClientes(ClientesDTO clientesDto);


    default ClientesDTO clientesAClientesDto(Clientes clientes){

        return ClientesDTO.builder()
                .clienteId(clientes.getClienteId())
                .estado(clientes.getEstado())
                .persona(PersonasDTO.builder()
                        .identificacion(clientes.getPersonas().getIdentificacion())
                        .nombre(clientes.getPersonas().getNombre())
                        .genero(clientes.getPersonas().getGenero())
                        .edad(clientes.getPersonas().getEdad())
                        .direccion(clientes.getPersonas().getDireccion())
                        .telefono(clientes.getPersonas().getTelefono())
                        .build())
                .build();
    }

    List<ClientesDTO> listaClientesAListaClientesDto(List<Clientes> clientesLista);

    Clientes actualizar(ClientesDTO clientesDto, @MappingTarget Clientes clientes);
}
