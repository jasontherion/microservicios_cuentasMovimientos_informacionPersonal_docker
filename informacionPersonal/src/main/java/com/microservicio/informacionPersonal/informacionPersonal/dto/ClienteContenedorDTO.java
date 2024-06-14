package com.microservicio.informacionPersonal.informacionPersonal.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@Getter
@Setter
public class ClienteContenedorDTO {

    @JsonProperty("clientesDto")
    private ClientesDTO clientesDto;

    @JsonProperty("personasDto")
    private PersonasDTO personasDto;
}
