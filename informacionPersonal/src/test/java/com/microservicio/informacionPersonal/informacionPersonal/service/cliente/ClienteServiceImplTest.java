package com.microservicio.informacionPersonal.informacionPersonal.service.cliente;

import com.github.javafaker.Faker;
import com.microservicio.informacionPersonal.informacionPersonal.dto.ClientesDTO;
import com.microservicio.informacionPersonal.informacionPersonal.model.Clientes;
import com.microservicio.informacionPersonal.informacionPersonal.repository.ClienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class ClienteServiceImplTest {

    private final Faker faker = new Faker();

    @Mock
    private ClienteRepository repository;

    @Mock
    ClienteService service;

    @InjectMocks
    ClienteServiceImpl clienteServiceImpl;

    ClientesDTO clientesDTO = ClientesDTO.builder()
            .clienteId(faker.number().randomNumber())
            .contrasenia(faker.internet().password())
            .estado(true)
            .build();

    Clientes cliente = Clientes.builder()
            .clienteId(faker.number().randomNumber())
            .contrasenia(faker.internet().password())
            .estado(true)
            .build();


    @BeforeEach
    void init(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void listarClientes() {
        List<Clientes> listClientes = new ArrayList<>();
        listClientes.add(cliente);
        when(repository.findAll()).thenReturn(listClientes);

        ResponseEntity<List<ClientesDTO>> result = clienteServiceImpl.listarClientes();
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(listClientes.size(),result.getBody().size());

    }

    @Test
    void clienteId() {
    }

    @Test
    void crearClientes() {
    }

    @Test
    void actualizarClientes() {
    }

    @Test
    void desabilitarClientes() {
    }
}