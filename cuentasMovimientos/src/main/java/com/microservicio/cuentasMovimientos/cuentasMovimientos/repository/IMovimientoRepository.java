package com.microservicio.cuentasMovimientos.cuentasMovimientos.repository;

import com.microservicio.cuentasMovimientos.cuentasMovimientos.model.Movimientos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMovimientoRepository extends JpaRepository<Movimientos,Long> {
}
