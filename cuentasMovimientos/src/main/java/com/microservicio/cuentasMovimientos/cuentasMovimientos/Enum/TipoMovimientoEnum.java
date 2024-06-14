package com.microservicio.cuentasMovimientos.cuentasMovimientos.Enum;

public enum TipoMovimientoEnum {
    DEPOSITO("Depósito"),
    RETIRO("Retiro"),
    TRANSFERENCIA_ENVIADA("Transferencia Enviada"),
    TRANSFERENCIA_RECIBIDA("Transferencia Recibida"),
    PAGO_SERVICIOS("Pago de Servicios"),
    PAGO_TARJETA("Pago de Tarjeta de Crédito"),
    COMISION("Comisión Bancaria"),
    INTERESES("Intereses"),
    OTROS("Otros");

    private final String descripcion;

    TipoMovimientoEnum(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
