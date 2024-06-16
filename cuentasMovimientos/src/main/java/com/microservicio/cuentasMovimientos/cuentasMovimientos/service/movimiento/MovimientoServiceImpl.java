package com.microservicio.cuentasMovimientos.cuentasMovimientos.service.movimiento;

import com.microservicio.cuentasMovimientos.cuentasMovimientos.Enum.ModulosEnum;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.Enum.TipoMovimientoEnum;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.dto.MovimientoDTO;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.dto.RespuestaDTO;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.exeption.SaldoInsuficienteException;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.mapper.IMovimeintoMapper;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.model.Cuentas;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.model.Movimientos;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.repository.ICuentaRepository;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.repository.IMovimientoRepository;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.utilidades.ConstatesMesajes;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

@AllArgsConstructor
@Slf4j
@Service
public class MovimientoServiceImpl implements  IMovimientoService{


    private final IMovimeintoMapper mapper;
    private final IMovimientoRepository repository;
    private final ICuentaRepository cuentaRepository;


    /**
     * Returns a list of all movements (Movimientos) in the system.
     *
     * @return A ResponseEntity containing a RespuestaDTO object with a list of MovimientoDTO objects
     */

    @Transactional(readOnly = true)
    @Override
    public ResponseEntity<RespuestaDTO> listarMovimientos() {
        try{
            List<Movimientos> movimientos = repository.findAll();
            if (movimientos.isEmpty()) {
                throw new NoSuchElementException(
                        String.format(ConstatesMesajes.ERROR_NO_REGISTROS, ModulosEnum.MOVIMIENTOS));
            }
            return new ResponseEntity<>(RespuestaDTO.builder().mensage(String.format(ConstatesMesajes.LISTAR_REGISTROS,ModulosEnum.MOVIMIENTOS)).data(mapper.listaMovimientosAListaMovimientosDto(movimientos)).build(), HttpStatus.OK);

        }catch (NoSuchElementException e){
            log.error("Error en listar Movimientos " + e);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
        catch (Exception e){
            log.error("Error en listar Movimientos " + e);
            throw  new RuntimeException(String.format(ConstatesMesajes.ERROR_SERVIDOR, ModulosEnum.MOVIMIENTOS));

        }
    }

    /**
     * @param id
     * @return
     */
    @Transactional(readOnly = true)
    @Override
    public ResponseEntity<MovimientoDTO> consultarMovimientoId(Long id) {
        try{
            Movimientos movimientos = repository.findById(id).orElseThrow(() -> new NoSuchElementException(String.format(ConstatesMesajes.ERROR_NO_REGISTROS, id)));
            return new ResponseEntity<>(mapper.movimientosAMovimientosDto(movimientos),HttpStatus.OK);
        }catch (NoSuchElementException e){
            log.error("Error en consultar Movimiento id " + e);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
        catch (Exception e){
            log.error("Error en consultar Movimiento id " + e);
            throw  new RuntimeException(String.format(ConstatesMesajes.ERROR_SERVIDOR, ModulosEnum.MOVIMIENTOS));

        }
    }

    /**
     * @param movimientoDTO
     * @return
     */
    @Transactional
    @Override
    public ResponseEntity<RespuestaDTO> crearMovimiento(MovimientoDTO movimientoDTO) {
        try{

         Cuentas  cuenta =  cuentaRepository.findById(movimientoDTO.getCuenta().getCuentaId())
                    .filter(c -> Boolean.TRUE.equals(c.getEstado()))
                    .map(c -> {
                        float saldoDisponible = c.getSaldoInicial();
                        if (movimientoDTO.getTipoMovimiento().equalsIgnoreCase(TipoMovimientoEnum.RETIRO.toString())) {
                            saldoDisponible -= movimientoDTO.getValor();
                        } else if (movimientoDTO.getTipoMovimiento().equalsIgnoreCase(TipoMovimientoEnum.DEPOSITO.toString())) {
                            saldoDisponible += movimientoDTO.getValor();
                        }
                        if(saldoDisponible >= 0){
                            c.setSaldoInicial(saldoDisponible);

                        }else {
                            throw new SaldoInsuficienteException(
                                    String.format(ConstatesMesajes.SALDO_INSUFICIENTE, c.getSaldoInicial()));
                        }
                        log.info("valores nuevos",c);
                        return  cuentaRepository.save(c);
                    })
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                    String.format(ConstatesMesajes.ERROR_NO_REGISTROS, movimientoDTO.getCuenta().getCuentaId())));

            movimientoDTO.setTipoMovimiento(String.valueOf(TipoMovimientoEnum.valueOf(movimientoDTO.getTipoMovimiento())));
            // Aquí se incluye el cuenta y el nuevo saldo en el movimientoDTO antes de guardarlo
            Movimientos movimiento=  mapper.movimientosDtoAMovimientos(movimientoDTO);
            movimiento.setCuentas(cuenta);
            movimiento.setSaldo(cuenta.getSaldoInicial());

            log.info("salida de entidad cuenta: ${cuenta.getCuentaid()}");
            repository.save(movimiento);
            return new ResponseEntity<>(RespuestaDTO.builder().mensage(String.format(ConstatesMesajes.CREACION, ModulosEnum.MOVIMIENTOS)).build(), HttpStatus.OK);

        } catch (NoSuchElementException e) { // Capturamos la excepción controlada
            log.error("Error al encontrar la cuenta: " + e.getMessage());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format(ConstatesMesajes.ERROR_NO_REGISTROS, movimientoDTO.getCuenta().getCuentaId())); // Devolvemos un 404 Not Found
        } catch (SaldoInsuficienteException e) {
            log.error("Error de saldo insuficiente: " + e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage()); // Devolvemos un 400 Bad Request
        } catch (Exception e) {
            log.error("Error general al crear movimiento: " + e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, String.format(ConstatesMesajes.ERROR_SERVIDOR, ModulosEnum.MOVIMIENTOS)); // Devolvemos un 500 Internal Server Error
        }
    }

    /**
     * @param id
     * @param movimientoDTO
     * @return
     */
    @Transactional
    @Override
    public ResponseEntity<RespuestaDTO> actualizarMovimiento(Long id, MovimientoDTO movimientoDTO) {
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
    public ResponseEntity<RespuestaDTO> eliminarMovimiento(Long id) {
        try{
            return null;
        }catch (Exception e){
            log.error("Error en eliminar Movimientos " + e);
            throw  new RuntimeException(String.format(ConstatesMesajes.ERROR_SERVIDOR, ModulosEnum.MOVIMIENTOS));

        }
    }
}
