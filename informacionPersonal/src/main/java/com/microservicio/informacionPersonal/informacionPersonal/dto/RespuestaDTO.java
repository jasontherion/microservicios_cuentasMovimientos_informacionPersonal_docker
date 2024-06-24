package com.microservicio.informacionPersonal.informacionPersonal.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.jackson.JsonComponent;

import java.util.List;



@Builder
@AllArgsConstructor
@Getter
@Setter
public class RespuestaDTO {

    private String mensage;
    private List<?> data;
}
