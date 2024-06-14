package com.microservicio.cuentasMovimientos.cuentasMovimientos.repository;

import com.microservicio.cuentasMovimientos.cuentasMovimientos.model.Entidades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IEntidadRepository extends JpaRepository<Entidades,Long> {
}
