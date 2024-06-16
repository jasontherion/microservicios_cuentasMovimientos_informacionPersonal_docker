package com.microservicio.cuentasMovimientos.cuentasMovimientos.exeption;

public class SaldoInsuficienteException extends RuntimeException {
    public SaldoInsuficienteException(String message) {
        super(message);
    }
}
