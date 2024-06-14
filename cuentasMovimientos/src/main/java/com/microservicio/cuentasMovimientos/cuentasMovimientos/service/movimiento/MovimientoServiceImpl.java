package com.microservicio.cuentasMovimientos.cuentasMovimientos.service.movimiento;

import com.microservicio.cuentasMovimientos.cuentasMovimientos.Enum.ModulosEnum;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.dto.MovimientoDTO;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.mapper.IMovimeintoMapper;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.repository.IMovimientoRepository;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.utilidades.ConstatesMesajes;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Slf4j
@Service
public class MovimientoServiceImpl implements  IMovimientoService{


    private final IMovimeintoMapper mapper;
    private final IMovimientoRepository repository;


    /**
     * @return
     */
    @Override
    public ResponseEntity<List<MovimientoDTO>> listarMovimientos() {
        try{
            return null;
        }catch (Exception e){
            log.error("Error en listar Movimientos " + e);
            throw  new RuntimeException(String.format(ConstatesMesajes.ERROR_SERVIDOR, ModulosEnum.MOVIMIENTOS));

        }
    }

    /**
     * @param id
     * @return
     */
    @Override
    public ResponseEntity<MovimientoDTO> consultarMovimientoId(Long id) {
        try{
            return null;
        }catch (Exception e){
            log.error("Error en consultar Movimiento id " + e);
            throw  new RuntimeException(String.format(ConstatesMesajes.ERROR_SERVIDOR, ModulosEnum.MOVIMIENTOS));

        }
    }

    /**
     * @param movimientoDTO
     * @return
     */
    @Override
    public ResponseEntity<String> crearMovimiento(MovimientoDTO movimientoDTO) {
        try{
            return null;
        }catch (Exception e){
            log.error("Error en crear Movimientos " + e);
            throw  new RuntimeException(String.format(ConstatesMesajes.ERROR_SERVIDOR, ModulosEnum.MOVIMIENTOS));

        }
    }

    /**
     * @param id
     * @param movimientoDTO
     * @return
     */
    @Override
    public ResponseEntity<String> actualizarMovimiento(Long id, MovimientoDTO movimientoDTO) {
        try{
            return null;
        }catch (Exception e){
            log.error("Error en actualizar Movimientos " + e);
            throw  new RuntimeException(String.format(ConstatesMesajes.ERROR_SERVIDOR, ModulosEnum.MOVIMIENTOS));

        }
    }

    /**
     * @param id
     * @return
     */
    @Override
    public ResponseEntity<String> eliminarMovimiento(Long id) {
        try{
            return null;
        }catch (Exception e){
            log.error("Error en eliminar Movimientos " + e);
            throw  new RuntimeException(String.format(ConstatesMesajes.ERROR_SERVIDOR, ModulosEnum.MOVIMIENTOS));

        }
    }
}
