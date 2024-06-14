package com.microservicio.informacionPersonal.informacionPersonal.repository;

import com.microservicio.informacionPersonal.informacionPersonal.model.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ClienteRepository  extends JpaRepository<Clientes, Long> {

    @Query("SELECT c FROM Clientes c JOIN FETCH c.personas WHERE c.clienteId = ?1")
    Optional<Clientes> findByIdWithPersonas(Long clienteId);

}
