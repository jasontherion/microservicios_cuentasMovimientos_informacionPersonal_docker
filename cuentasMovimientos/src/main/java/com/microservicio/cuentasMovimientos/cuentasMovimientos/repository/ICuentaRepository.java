package com.microservicio.cuentasMovimientos.cuentasMovimientos.repository;

import com.microservicio.cuentasMovimientos.cuentasMovimientos.model.Cuentas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ICuentaRepository extends JpaRepository<Cuentas, Long> {
}
