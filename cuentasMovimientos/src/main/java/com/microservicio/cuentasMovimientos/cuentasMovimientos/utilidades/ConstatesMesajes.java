package com.microservicio.cuentasMovimientos.cuentasMovimientos.utilidades;

import org.springframework.stereotype.Component;

@Component
public class ConstatesMesajes {
    public static final String ERROR_SERVIDOR = "Error en el servicio %s";
    public static final String ERROR_NO_REGISTROS = "No existen registros";
    public static final String ACTUALIZAR = "Se actualizo el objeto %s";
    public static final String CREACION = "Se creo el objeto %s";
    public static final String DESHABILITAR = "Se desHabilito  el objeto %s";
}
