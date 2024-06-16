package com.microservicio.informacionPersonal.informacionPersonal.service.cliente;

import com.microservicio.informacionPersonal.informacionPersonal.Enum.ModulosEnum;
import com.microservicio.informacionPersonal.informacionPersonal.dto.ClienteContenedorDTO;
import com.microservicio.informacionPersonal.informacionPersonal.dto.ClientesDTO;
import com.microservicio.informacionPersonal.informacionPersonal.dto.EstadoDto;
import com.microservicio.informacionPersonal.informacionPersonal.dto.RespuestaDTO;
import com.microservicio.informacionPersonal.informacionPersonal.mapper.IClienteMapper;
import com.microservicio.informacionPersonal.informacionPersonal.mapper.IClientePersonaMapper;
import com.microservicio.informacionPersonal.informacionPersonal.mapper.IPersonaMapper;
import com.microservicio.informacionPersonal.informacionPersonal.model.Clientes;
import com.microservicio.informacionPersonal.informacionPersonal.model.Personas;
import com.microservicio.informacionPersonal.informacionPersonal.repository.ClienteRepository;
import com.microservicio.informacionPersonal.informacionPersonal.repository.PersonaRepository;
import com.microservicio.informacionPersonal.informacionPersonal.utilidades.ConstatesMesajes;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;


@Slf4j
@AllArgsConstructor
@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository repository;
    private final IClienteMapper mapper;
    private final IPersonaMapper personaMapper;
    private final PersonaRepository personasRepository;
    private final IClientePersonaMapper clientePersonaMapper;

    /**
     * @return ResponseEntity o error
     */
    @Transactional(readOnly = true)
    @Override
    public ResponseEntity<RespuestaDTO> listarClientes() {
        try {
            List<Clientes> list = repository.findAll().stream().filter(r->Boolean.TRUE.equals(r.getEstado())).collect(Collectors.toList());
            return new ResponseEntity<>(RespuestaDTO.builder().mensage(String.format(ConstatesMesajes.RESPUESTA_CONSULTA,ModulosEnum.CLIENTES)).data( mapper.listaClientesAListaClientesDto(list)).build(), HttpStatus.OK);
        }catch (Exception e){
            log.error("Error en listar Clientes " + e);
            throw  new RuntimeException(String.format(ConstatesMesajes.ERROR_SERVIDOR, ModulosEnum.CLIENTES));
        }
    }

    /**
     * @param Id
     * @return
     */
    @Transactional(readOnly = true)
    @Override
    public ResponseEntity<ClientesDTO> clienteId(Long Id)  {
        try {
            Optional<Clientes> object = repository.findById(Id).filter(r->Boolean.TRUE.equals(r.getEstado()));
            if(!object.isPresent()){
                throw new NoSuchElementException(String.format(ConstatesMesajes.ERROR_NO_REGISTROS));
            }

            return new ResponseEntity<>(mapper.clientesAClientesDto(object.get()), HttpStatus.OK);
        } catch (NoSuchElementException e){
            throw new NoSuchElementException(e);

        } catch (Exception e){
            log.error("Error en listar Clientes " + e);
            throw  new RuntimeException(String.format(ConstatesMesajes.ERROR_SERVIDOR, ModulosEnum.CLIENTES));
        }
    }

    /**
     * @param clienteContenedorDTO
     * @return
     */
    @Transactional
    @Override
    public ResponseEntity<RespuestaDTO> crearClientes(ClienteContenedorDTO clienteContenedorDTO) {
        try {
            Personas nuevaPersona = personaMapper.personasDtoAPersonas(clienteContenedorDTO.getPersonasDto()); // Convertimos a Personas
            personasRepository.save(nuevaPersona); // Guardamos la persona primero

            Clientes nuevoCliente = clientePersonaMapper.clienteContenedorDTOAClientes(clienteContenedorDTO);
            nuevoCliente.setPersonas(nuevaPersona); // Asignamos la persona guardada al cliente
            repository.saveAndFlush(nuevoCliente);
            return new ResponseEntity<>(RespuestaDTO.builder().mensage(String.format(ConstatesMesajes.CREACION,clienteContenedorDTO.getClientesDto())).build(), HttpStatus.OK);
        }catch (Exception e){
            log.error("Error en listar Clientes " + e);
            throw  new RuntimeException(String.format(ConstatesMesajes.ERROR_SERVIDOR, ModulosEnum.CLIENTES));
        }
    }

    /**
     * @param id
     * @param clienteContenedorDTO
     * @return ResponseEntity o error
     */
    @Transactional
    @Override
    public ResponseEntity<RespuestaDTO> actualizarClientes(Long id, ClienteContenedorDTO clienteContenedorDTO) {
        try {
            // 1. Manejar creación si el cliente no existe
            Clientes clienteActualizar = repository.findById(id).filter(r-> Boolean.TRUE.equals(r.getEstado()))
                    .orElseGet(() -> {
                        Clientes nuevoCliente = clientePersonaMapper.clienteContenedorDTOAClientes(clienteContenedorDTO);
                        return nuevoCliente;
                    });
            if(clienteActualizar.equals(null)){
                throw new NoSuchElementException(String.format(ConstatesMesajes.ERROR_NO_REGISTROS));
            }

            // 2. Verificar si la persona existe o crearla si es necesario
            Personas persona = clienteActualizar.getPersonas();
            if (persona == null) {
                persona = personaMapper.personasDtoAPersonas(clienteContenedorDTO.getPersonasDto());
                personasRepository.save(persona); // ¡Guarda la persona primero!
                clienteActualizar.setPersonas(persona);
            } else {
                personaMapper.actualizarPersonas(clienteContenedorDTO.getPersonasDto(), persona);
                personasRepository.save(persona); // Guardamos la persona primero
            }

            // 3. Guardar cliente
//            Clientes nuevoCliente = clientePersonaMapper.clienteContenedorDTOAClientes(clienteContenedorDTO);
//            nuevoCliente.setClienteId(id);
            Clientes actualizado = clientePersonaMapper.actualizarClientePersonaDTO(clienteContenedorDTO,clienteActualizar);
            actualizado.setClienteId(id);
            actualizado.setPersonas(persona);
            repository.saveAndFlush(actualizado);
            return new ResponseEntity<>(RespuestaDTO.builder().mensage(String.format(ConstatesMesajes.ACTUALIZAR, ModulosEnum.CLIENTES)).build(), HttpStatus.OK);
        }catch (Exception e){
            log.error("Error en listar Clientes "+e);
            throw  new RuntimeException(String.format(ConstatesMesajes.ERROR_SERVIDOR, ModulosEnum.CLIENTES));
        }
    }

    /**
     * @param id
     * @return
     */
    @Transactional
    @Override
    public ResponseEntity<RespuestaDTO> desabilitarClientes(Long id, EstadoDto estado) {
        try {
            Optional<Clientes> object = repository.findById(id);
            if(!object.isPresent()){
                throw new NoSuchElementException(ConstatesMesajes.ERROR_NO_REGISTROS);
            }
            Clientes clienteActualizar = object.get();
            clienteActualizar.setEstado(estado.getEstado());
            repository.save(clienteActualizar);
            return new ResponseEntity<>(RespuestaDTO.builder().mensage(String.format(ConstatesMesajes.DESHABILITAR, ModulosEnum.CLIENTES,id)).build(), HttpStatus.OK);
        }catch (NoSuchElementException e){
            throw new NoSuchElementException(e);

        } catch (Exception e){
            log.error("Error en listar Clientes " + e);
            throw  new RuntimeException(String.format(ConstatesMesajes.ERROR_SERVIDOR, ModulosEnum.CLIENTES));
        }
    }
}
