package com.microservicio.informacionPersonal.informacionPersonal.service.persona;

import com.github.javafaker.Faker;
import com.microservicio.informacionPersonal.informacionPersonal.dto.PersonasDTO;
import com.microservicio.informacionPersonal.informacionPersonal.mapper.IPersonaMapper;
import com.microservicio.informacionPersonal.informacionPersonal.model.Personas;
import com.microservicio.informacionPersonal.informacionPersonal.repository.PersonaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.when;

class PersonaServiceImplTest {

    private final Faker faker = new Faker();

    @Mock
    private PersonaRepository repository;

    @Mock
    private IPersonaMapper mapper;


    @InjectMocks
    private PersonaServiceImpl serviceImpl;

    PersonasDTO personasDTO = PersonasDTO.builder()
            .personaId(faker.number().randomNumber())
            .nombre(faker.name().fullName())
            .genero(faker.options().option("Masculino", "Femenino"))
            .edad(faker.number().numberBetween(18, 65))
            .identificacion(faker.idNumber().valid())
            .direccion(faker.address().fullAddress())
            .telefono(faker.phoneNumber().phoneNumber())
            .build();

    Personas personas = Personas.builder()
            .personaId(faker.number().randomNumber())
            .nombre(faker.name().fullName())
            .genero(faker.options().option("Masculino", "Femenino"))
            .edad(faker.number().numberBetween(18, 65))
            .identificacion(faker.idNumber().valid())
            .direccion(faker.address().fullAddress())
            .telefono(faker.phoneNumber().phoneNumber())
            .build();

    @BeforeEach
    void init(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void listarPersonas() {

        List<Personas> personasMock = new ArrayList<>();
        personasMock.add(personas);
        when(repository.findAll()).thenReturn(personasMock);

        ResponseEntity<List<PersonasDTO>> result = serviceImpl.listarPersonas();

        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(personasMock.size(), result.getBody().size());


    }

    @Test
    void personaId() {

    }

    @Test
    void crearPersonas() {
        when(repository.save(mapper.personasDtoAPersonas(personasDTO))).thenReturn(personas);

        ResponseEntity<String> result = serviceImpl.crearPersonas(personasDTO);
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    void actualizarPersonas() {

        when(repository.findById(anyLong())).thenReturn(Optional.ofNullable(personas));
        mapper.actualizarPersonas(personasDTO,personas);
        when(repository.save(personas)).thenReturn(personas);

        ResponseEntity<String> result = serviceImpl.actualizarPersonas(personas.getPersonaId(), personasDTO);
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }


}