package com.microservicio.informacionPersonal.informacionPersonal.service.persona;

import com.microservicio.informacionPersonal.informacionPersonal.dto.PersonasDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PersonaService {

    ResponseEntity<List<PersonasDTO>> listarPersonas();
    ResponseEntity<PersonasDTO> personaId(Long Id);
    ResponseEntity<String> crearPersonas(PersonasDTO peronasDto);

    ResponseEntity<String> actualizarPersonas(Long id , PersonasDTO peronasDto);

//    ResponseEntity<String> desabilitarPersonas(Long id);
}
