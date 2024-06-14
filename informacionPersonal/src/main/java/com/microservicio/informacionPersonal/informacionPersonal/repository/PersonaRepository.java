package com.microservicio.informacionPersonal.informacionPersonal.repository;

import com.microservicio.informacionPersonal.informacionPersonal.model.Personas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonaRepository extends JpaRepository<Personas, Long> {


}
