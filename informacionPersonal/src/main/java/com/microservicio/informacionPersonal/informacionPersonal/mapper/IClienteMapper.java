package com.microservicio.informacionPersonal.informacionPersonal.mapper;

import com.microservicio.informacionPersonal.informacionPersonal.dto.ClientesDTO;
import com.microservicio.informacionPersonal.informacionPersonal.model.Clientes;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

import java.util.List;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface IClienteMapper {
    @Mapping(target ="clienteId",ignore = true)
    Clientes clientesDtoAClientes(ClientesDTO clientesDto);



    ClientesDTO clientesAClientesDto(Clientes clientes);

    List<ClientesDTO> listaClientesAListaClientesDto(List<Clientes> clientesLista);

    public void actualizar(ClientesDTO clientesDto, @MappingTarget Clientes clientes);
}
