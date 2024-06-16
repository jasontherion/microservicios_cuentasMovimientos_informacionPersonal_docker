package com.microservicio.informacionPersonal.informacionPersonal.dto;

import lombok.*;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClientesDTO {

    private Long clienteId;

    private String contrasenia;


    private Boolean estado;

    private PersonasDTO persona;
}
