package com.microservicio.cuentasMovimientos.cuentasMovimientos.Enum;

public enum TiposCuentasEnum {
    AHORROS("Ahorros"),
    CORRIENTE("Corriente"),
    NOMINA("Nómina"),
    JOVEN("Joven"),
    PREMIUM("Premium");

    private String descripcion;
    TiposCuentasEnum(String descripcion){
        this.descripcion=descripcion;
    }

}
