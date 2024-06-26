package com.microservicio.informacionPersonal.informacionPersonal.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EstadoDto {

    @JsonProperty("estado")
    private Boolean estado;
}
