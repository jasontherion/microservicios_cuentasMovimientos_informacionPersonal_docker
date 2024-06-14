package com.microservicio.cuentasMovimientos.cuentasMovimientos.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class ManejadorErroresPersonalizado {


    @ExceptionHandler({NoSuchElementException.class}) // Excepción para error 423
    public ResponseEntity<Map<String, Object>> handleLockedException(NoSuchElementException ex) {
        Map<String, Object> response = new HashMap<>();
        response.put("error", "Recurso bloqueado");
        response.put("mensaje", ex.getMessage());
        response.put("status", HttpStatus.LOCKED.value());
        return new ResponseEntity<>(response, HttpStatus.LOCKED);
    }

    @ExceptionHandler(RuntimeException.class) // Excepción general para errores 500
    public ResponseEntity<Map<String, Object>> handleGeneralException(RuntimeException ex) {
        Map<String, Object> response = new HashMap<>();
        response.put("error", "Error interno del servidor");
        response.put("mensaje", ex.getMessage());
        response.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class) // Excepción para parámetros incorrectos
    public ResponseEntity<Map<String, Object>> handleInvalidParameter(MethodArgumentTypeMismatchException ex) {
        Map<String, Object> response = new HashMap<>();
        response.put("error", "Parámetro inválido");
        response.put("mensaje", "El parámetro '" + ex.getName() + "' no es válido.");
        response.put("status", HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
