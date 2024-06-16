package com.microservicio.cuentasMovimientos.cuentasMovimientos.service.entidad;

import com.microservicio.cuentasMovimientos.cuentasMovimientos.Enum.ModulosEnum;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.dto.EntidadDTO;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.dto.RespuestaDTO;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.mapper.IEntidadMapper;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.model.Entidades;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.repository.IEntidadRepository;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.utilidades.ConstatesMesajes;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;


@AllArgsConstructor
@Slf4j
@Service
public class EntidadServiceImpl implements IEntidadService {

     private final IEntidadMapper mapper;
     private final IEntidadRepository repository;


    /**
     * @return List<EntidadDTO> o error
     */
    @Transactional(readOnly = true)
    @Override
    public ResponseEntity<RespuestaDTO> listarEntidades() {
        try{
           List<Entidades> entidades = repository.findAll();
            if (entidades.size() < 0){
                throw new NoSuchElementException(String.format(ConstatesMesajes.ERROR_NO_REGISTROS));
            }

            return new ResponseEntity<>(RespuestaDTO.builder().mensage(String.format(ConstatesMesajes.LISTAR_REGISTROS,ModulosEnum.ENTIDADES)).data(mapper.listaEntidadesAListaEntidadesDto(entidades)).build(), HttpStatus.OK);
        }catch (NoSuchElementException e){
            log.error("Error en consultar Entidad id " + e);
            throw  new NoSuchElementException(e.getMessage());
        }catch (Exception e){
            log.error("Error en listar Entidades " + e);
            throw  new RuntimeException(String.format(ConstatesMesajes.ERROR_SERVIDOR, ModulosEnum.ENTIDADES));

        }
    }

    /**
     * @param id
     * @return EntidadDTO o error
     */
    @Transactional(readOnly = true)
    @Override
    public ResponseEntity<EntidadDTO> consultarEntidadId(Long id) {
        try{
            Entidades entidades = repository.findById(id).orElseThrow(() -> new NoSuchElementException(String.format(ConstatesMesajes.ERROR_NO_REGISTROS, id)));
            return new ResponseEntity<>(mapper.entidadesAEntidadesDto(entidades), HttpStatus.OK);
        }catch (NoSuchElementException e){
            log.error("Error en consultar Entidad id " + e);
            throw  new NoSuchElementException(e.getMessage());
        }
        catch (Exception e){
            log.error("Error en consultar Entidad id " + e);
            throw  new RuntimeException(String.format(ConstatesMesajes.ERROR_SERVIDOR, ModulosEnum.ENTIDADES));

        }
    }

    /**
     * @param entidadDTO
     * @return ResponseEntity o error
     */
    @Transactional
    @Override
    public ResponseEntity<RespuestaDTO> crearEntidad(EntidadDTO entidadDTO) {
        try{
            repository.save(mapper.entidadesDtoAEntidades(entidadDTO));
            return new ResponseEntity<>(RespuestaDTO.builder().mensage(String.format(ConstatesMesajes.CREACION, ModulosEnum.ENTIDADES)).build(), HttpStatus.CREATED);
        }catch (NoSuchElementException e){
            log.error("Error en consultar Entidad id " + e);
            throw  new NoSuchElementException(e.getMessage());
        }catch (Exception e){
            log.error("Error en crear Entidades " + e);
            throw  new RuntimeException(String.format(ConstatesMesajes.ERROR_SERVIDOR, ModulosEnum.ENTIDADES));

        }
    }

    /**
     * @param id
     * @param entidadDTO
     * @return ResponseEntity o error
     */
    @Transactional
    @Override
    public ResponseEntity<RespuestaDTO> actualizarEntidad(Long id, EntidadDTO entidadDTO) {
        try{
            Entidades entidades = repository.findById(id).orElseThrow(() -> new NoSuchElementException(String.format(ConstatesMesajes.ERROR_NO_REGISTROS, id)));
            mapper.actualizarEntidades(entidadDTO, entidades);
            repository.save(entidades);
            return new ResponseEntity<>(RespuestaDTO.builder().mensage(String.format(ConstatesMesajes.ACTUALIZAR,ModulosEnum.ENTIDADES)).build(), HttpStatus.OK);
        }catch (NoSuchElementException e){
            log.error("Error en consultar Entidad id " + e);
            throw  new NoSuchElementException(e.getMessage());
        }catch (Exception e){
            log.error("Error en actualizar Entidades " + e);
            throw  new RuntimeException(String.format(ConstatesMesajes.ERROR_SERVIDOR, ModulosEnum.ENTIDADES));

        }
    }

    /**
     * @param id
     * @return ResponseEntity o error
     */
    @Transactional
    @Override
    public ResponseEntity<RespuestaDTO> eliminarEntidad(Long id) {
        try{
            Entidades entidades = repository.findById(id).orElseThrow(() -> new NoSuchElementException(String.format(ConstatesMesajes.ERROR_NO_REGISTROS, id)));
            repository.delete(entidades);
            return new ResponseEntity<>(RespuestaDTO.builder().mensage("").build(), HttpStatus.NO_CONTENT);
        }catch (NoSuchElementException e){
            log.error("Error en consultar Entidad id " + e);
            throw  new NoSuchElementException(e.getMessage());
        }catch (Exception e){
            log.error("Error en eliminar Entidades " + e);
            throw  new RuntimeException(String.format(ConstatesMesajes.ERROR_SERVIDOR, ModulosEnum.ENTIDADES));

        }
    }
}
