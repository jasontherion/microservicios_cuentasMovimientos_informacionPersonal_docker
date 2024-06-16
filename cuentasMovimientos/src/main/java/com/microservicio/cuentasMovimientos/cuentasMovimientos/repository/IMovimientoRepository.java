package com.microservicio.cuentasMovimientos.cuentasMovimientos.repository;

import com.microservicio.cuentasMovimientos.cuentasMovimientos.model.Cuentas;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.model.Movimientos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface IMovimientoRepository extends JpaRepository<Movimientos,Long> {


    @Query("SELECT c FROM Cuentas c JOIN FETCH c.movimientos m WHERE m.fecha BETWEEN :fechaInicial AND :fechaFinal AND c.clienteId = :clienteId")
    List<Cuentas> consultarMovimientosFecha(@Param("fechaInicial") LocalDate fechaInicial, @Param("fechaFinal") LocalDate fechaFinal, @Param("clienteId") Long clienteId);
}
