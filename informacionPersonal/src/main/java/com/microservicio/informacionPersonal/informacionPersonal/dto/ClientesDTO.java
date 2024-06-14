package com.microservicio.informacionPersonal.informacionPersonal.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
@AllArgsConstructor
@Getter
@Setter
public class ClientesDTO {

    private Long clienteId;

    private String contrasenia;


    private Boolean estado;
}
