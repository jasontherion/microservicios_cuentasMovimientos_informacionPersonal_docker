package com.microservicio.informacionPersonal.informacionPersonal.service.cliente;

import com.microservicio.informacionPersonal.informacionPersonal.Enum.ModulosEnum;
import com.microservicio.informacionPersonal.informacionPersonal.dto.ClienteContenedorDTO;
import com.microservicio.informacionPersonal.informacionPersonal.dto.ClientesDTO;
import com.microservicio.informacionPersonal.informacionPersonal.dto.EstadoDto;
import com.microservicio.informacionPersonal.informacionPersonal.mapper.IClienteMapper;
import com.microservicio.informacionPersonal.informacionPersonal.mapper.IClientePersonaMapper;
import com.microservicio.informacionPersonal.informacionPersonal.mapper.IPersonaMapper;
import com.microservicio.informacionPersonal.informacionPersonal.model.Clientes;
import com.microservicio.informacionPersonal.informacionPersonal.model.Personas;
import com.microservicio.informacionPersonal.informacionPersonal.repository.ClienteRepository;
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


@Slf4j
@AllArgsConstructor
@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository repository;
    private final IClienteMapper mapper;
    private final IPersonaMapper personaMapper;
    private final IClientePersonaMapper clientePersonaMapper;

    /**
     * @return ResponseEntity o error
     */
    @Transactional(readOnly = true)
    @Override
    public ResponseEntity<List<ClientesDTO>> listarClientes() {
        try {
            List<Clientes> list = repository.findAll();
            return new ResponseEntity<>(mapper.listaClientesAListaClientesDto(list), HttpStatus.OK);
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
            Optional<Clientes> object = repository.findById(Id);
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
    public ResponseEntity<String> crearClientes(ClienteContenedorDTO clienteContenedorDTO) {
        try {
            Clientes clientes =  clientePersonaMapper.clienteContenedorDTOAClientes(clienteContenedorDTO);
            repository.save(clientes);
            return new ResponseEntity<>(String.format(ConstatesMesajes.CREACION,clienteContenedorDTO.getClientesDto()), HttpStatus.OK);
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
    public ResponseEntity<String> actualizarClientes(Long id, ClienteContenedorDTO clienteContenedorDTO) {
        try {
            // 1. Manejar creación si el cliente no existe
            Clientes clienteActualizar = repository.findById(id)
                    .orElseGet(() -> {
                        Clientes nuevoCliente = clientePersonaMapper.clienteContenedorDTOAClientes(clienteContenedorDTO);
                        return nuevoCliente;
                    });
            // 2. Actualizar datos del cliente
            clientePersonaMapper.actualizarClientePersonaDTO(clienteContenedorDTO, clienteActualizar);
            // 3. Verificar si la persona existe o crearla si es necesario
            Personas persona = clienteActualizar.getPersonas();
            if (persona == null) {
                persona = personaMapper.personasDtoAPersonas(clienteContenedorDTO.getPersonasDto());
                clienteActualizar.setPersonas(persona);
            } else {
                personaMapper.actualizarPersonas(clienteContenedorDTO.getPersonasDto(), persona);
            }

            // 4. Guardar cliente (y la persona automáticamente debido a CascadeType.ALL)
            repository.save(clienteActualizar);
            return new ResponseEntity<>(String.format(ConstatesMesajes.ACTUALIZAR, clienteActualizar), HttpStatus.OK);
        }catch (Exception e){
            log.error("Error en listar Clientes ${e}");
            throw  new RuntimeException(String.format(ConstatesMesajes.ERROR_SERVIDOR, ModulosEnum.CLIENTES));
        }
    }

    /**
     * @param id
     * @return
     */
    @Transactional
    @Override
    public ResponseEntity<String> desabilitarClientes(Long id, EstadoDto estado) {
        try {
            Optional<Clientes> object = repository.findById(id);
            if(!object.isPresent()){
                throw new NoSuchElementException(ConstatesMesajes.ERROR_NO_REGISTROS);
            }
            Clientes clienteActualizar = object.get();
            clienteActualizar.setEstado(estado.getEstado());
            repository.save(clienteActualizar);
            return new ResponseEntity<>(String.format(ConstatesMesajes.DESHABILITAR, id), HttpStatus.OK);
        }catch (NoSuchElementException e){
            throw new NoSuchElementException(e);

        } catch (Exception e){
            log.error("Error en listar Clientes " + e);
            throw  new RuntimeException(String.format(ConstatesMesajes.ERROR_SERVIDOR, ModulosEnum.CLIENTES));
        }
    }
}
