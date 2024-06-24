package com.microservicio.informacionPersonal.informacionPersonal.dto;

import lombok.*;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Mono;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClientesDTO extends Mono<ClientesDTO> {

    private Long clienteId;

    private String contrasenia;


    private Boolean estado;

    private PersonasDTO persona;

    /**
     * @param coreSubscriber
     */
    @Override
    public void subscribe(CoreSubscriber<? super ClientesDTO> coreSubscriber) {

    }
}
