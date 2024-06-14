package com.microservicio.cuentasMovimientos.cuentasMovimientos.service.entidad;

import com.microservicio.cuentasMovimientos.cuentasMovimientos.Enum.ModulosEnum;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.dto.EntidadDTO;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.mapper.IEntidadMapper;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.repository.IEntidadRepository;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.utilidades.ConstatesMesajes;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@AllArgsConstructor
@Slf4j
@Service
public class EntidadServiceImpl implements IEntidadService {

     private final IEntidadMapper mapper;
     private final IEntidadRepository repository;


    /**
     * @return
     */
    @Override
    public ResponseEntity<List<EntidadDTO>> listarEntidades() {
        try{
            return null;
        }catch (Exception e){
            log.error("Error en listar Entidades " + e);
            throw  new RuntimeException(String.format(ConstatesMesajes.ERROR_SERVIDOR, ModulosEnum.ENTIDADES));

        }
    }

    /**
     * @param id
     * @return
     */
    @Override
    public ResponseEntity<EntidadDTO> consultarEntidadId(Long id) {
        try{
            return null;
        }catch (Exception e){
            log.error("Error en consultar Entidad id " + e);
            throw  new RuntimeException(String.format(ConstatesMesajes.ERROR_SERVIDOR, ModulosEnum.ENTIDADES));

        }
    }

    /**
     * @param entidadDTO
     * @return
     */
    @Override
    public ResponseEntity<String> crearEntidad(EntidadDTO entidadDTO) {
        try{
            return null;
        }catch (Exception e){
            log.error("Error en crear Entidades " + e);
            throw  new RuntimeException(String.format(ConstatesMesajes.ERROR_SERVIDOR, ModulosEnum.ENTIDADES));

        }
    }

    /**
     * @param id
     * @param entidadDTO
     * @return
     */
    @Override
    public ResponseEntity<String> actualizarEntidad(Long id, EntidadDTO entidadDTO) {
        try{
            return null;
        }catch (Exception e){
            log.error("Error en actualizar Entidades " + e);
            throw  new RuntimeException(String.format(ConstatesMesajes.ERROR_SERVIDOR, ModulosEnum.ENTIDADES));

        }
    }

    /**
     * @param id
     * @return
     */
    @Override
    public ResponseEntity<String> eliminarEntidad(Long id) {
        try{
            return null;
        }catch (Exception e){
            log.error("Error en eliminar Entidades " + e);
            throw  new RuntimeException(String.format(ConstatesMesajes.ERROR_SERVIDOR, ModulosEnum.ENTIDADES));

        }
    }
}
