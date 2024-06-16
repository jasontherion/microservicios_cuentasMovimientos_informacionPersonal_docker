package com.microservicio.informacionPersonal.informacionPersonal.utilidades;


import org.springframework.stereotype.Component;

@Component
public class ConstatesMesajes {

    public static final String ERROR_SERVIDOR = "Error en el servicio %s";
    public static final String ERROR_NO_REGISTROS = "No existen registros";
    public static final String ACTUALIZAR = "Se actualizo en %s";
    public static final String CREACION = "Se creo en %s";
    public static final String DESHABILITAR = "Se desHabilito en %s %s";

    public static final String RESPUESTA_CONSULTA = "Lista los registros %s";

}
