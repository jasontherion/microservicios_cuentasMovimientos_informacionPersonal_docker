package com.microservicio.informacionPersonal.informacionPersonal.service.persona;

import com.microservicio.informacionPersonal.informacionPersonal.Enum.ModulosEnum;
import com.microservicio.informacionPersonal.informacionPersonal.dto.PersonasDTO;
import com.microservicio.informacionPersonal.informacionPersonal.mapper.IPersonaMapper;
import com.microservicio.informacionPersonal.informacionPersonal.model.Personas;
import com.microservicio.informacionPersonal.informacionPersonal.repository.PersonaRepository;
import com.microservicio.informacionPersonal.informacionPersonal.utilidades.ConstatesMesajes;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Slf4j
@AllArgsConstructor
@Service
public class PersonaServiceImpl implements PersonaService{


    private final PersonaRepository repository;
    private final IPersonaMapper mapper;


    /**
     * @return ResponseEntity<List<PersonasDTO>>
     */
    @Transactional(readOnly = true)
    @Override
    public ResponseEntity<List<PersonasDTO>> listarPersonas() {
        try {
            List<Personas> list = repository.findAll();
            if(list.size() == 0){
                throw new RuntimeException(ConstatesMesajes.ERROR_NO_REGISTROS);
            }
            return new ResponseEntity<>(mapper.listaPersonasAListaPersonasDto(list), HttpStatus.OK);
        }catch (Exception e){
            log.error("Error en listar Personas: "+e);
            throw  new RuntimeException(String.format(ConstatesMesajes.ERROR_SERVIDOR, ModulosEnum.PERSONAS));
        }
    }

    /**
     * @param Id
     * @return ResponseEntity<List<PersonasDTO>> o Error
     */
    @Transactional(readOnly = true)
    @Override
    public ResponseEntity<PersonasDTO> personaId(Long Id) {
        try {
            Optional<Personas> Object = repository.findById(Id);
            if(!Object.isPresent()){
                throw new RuntimeException(ConstatesMesajes.ERROR_NO_REGISTROS);
            }

            return new ResponseEntity<>(mapper.personasAPersonasDto(Object.get()), HttpStatus.OK);
        }catch (Exception e){
            log.error("Error en  Personas id: "+e);
            throw  new RuntimeException(String.format(ConstatesMesajes.ERROR_SERVIDOR, ModulosEnum.PERSONAS));
        }
    }

    /**
     * @param peronasDto
     * @return ResponseEntity<String> o Error
     */
    @Transactional
    @Override
    public ResponseEntity<String> crearPersonas(PersonasDTO peronasDto) {
        try {

            repository.save(mapper.personasDtoAPersonas(peronasDto));
            return new ResponseEntity<>(String.format(ConstatesMesajes.CREACION,peronasDto), HttpStatus.OK);
        }catch (Exception e){
            log.error("Error en crear Personas "+e);
            throw  new RuntimeException(String.format(ConstatesMesajes.ERROR_SERVIDOR, ModulosEnum.PERSONAS));
        }
    }

    /**
     * @param id
     * @param peronasDto
     * @return ResponseEntity<String> o Error
     */
    @Transactional
    @Override
    public ResponseEntity<String> actualizarPersonas(Long id, PersonasDTO peronasDto) {
        try {
            Optional<Personas> persona = repository.findById(id);
            if(!persona.isPresent()){
                throw new RuntimeException(ConstatesMesajes.ERROR_NO_REGISTROS);
            }
            Personas personaActualizar = persona.get();
            mapper.actualizarPersonas(peronasDto,personaActualizar);
            repository.save(personaActualizar);
            return new ResponseEntity<>(String.format(ConstatesMesajes.ACTUALIZAR,personaActualizar), HttpStatus.OK);
        }catch (Exception e){
            log.error("Error en actualizar Personas: "+ e);
            throw  new RuntimeException(String.format(ConstatesMesajes.ERROR_SERVIDOR, ModulosEnum.PERSONAS));
        }
    }

//    /**
//     * @param id
//     * @return
//     */
//    @Transactional
//    @Override
//    public ResponseEntity<String> desabilitarPersonas(Long id) {
//        try {
//            repository.save(Personas.);
//            return new ResponseEntity<>(list, HttpStatus.OK);
//        }catch (Exception e){
//            log.error("Error en desabilitar Personas ${e}");
//            throw  new RuntimeException(String.format(ConstatesMesajes.ERROR_SERVIDOR, ModulosEnum.PERSONAS));
//        }
//    }
}
