package com.microservicio.cuentasMovimientos.cuentasMovimientos.service.cuenta;


import com.microservicio.cuentasMovimientos.cuentasMovimientos.Enum.ModulosEnum;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.clientes.IInformacionClientesRest;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.dto.CuentaCreacionDTO;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.dto.CuentaDTO;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.dto.RespuestaDTO;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.mapper.ICuentaMapper;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.model.Clientes;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.model.Cuentas;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.repository.ICuentaRepository;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.utilidades.ConstatesMesajes;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.utilidades.ConsultasClientes;
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
public class CuentaServiceImpl implements ICuentaService {


    private final IInformacionClientesRest clienteFeign;
    private final ICuentaMapper mapper;
    private final ICuentaRepository repository;


    /**
     * @return
     */
    @Transactional(readOnly = true)
    @Override
    public ResponseEntity<RespuestaDTO> listarCuentas() {
        try{
            List<Cuentas> cuentas = repository.findAll();
            if (cuentas.isEmpty()) {
                return new ResponseEntity<>(RespuestaDTO.builder().mensage(String.format(ConstatesMesajes.ERROR_NO_REGISTROS, ModulosEnum.CUENTAS)).build(), HttpStatus.OK);
            }

            return new ResponseEntity<>(RespuestaDTO.builder().mensage(String.format(ConstatesMesajes.LISTAR_REGISTROS,ModulosEnum.CUENTAS)).data(mapper.listaCuentasAListaCuentasDto(cuentas)).build(), HttpStatus.OK);

        }catch (NoSuchElementException e){
            log.error("Error en consultar Entidad id " + e);
            throw  new NoSuchElementException(e.getMessage());
        }catch (Exception e){
            log.error("Error en listar Cuentas " + e);
            throw  new RuntimeException(String.format(ConstatesMesajes.ERROR_SERVIDOR, ModulosEnum.CUENTAS));

        }
    }

    /**
     * @param id
     * @return
     */
    @Transactional(readOnly = true)
    @Override
    public ResponseEntity<CuentaDTO> consultarCuentaId(Long id) {
        try{
            Cuentas cuentas = repository.findById(id).orElseThrow(() -> new NoSuchElementException(String.format(ConstatesMesajes.ERROR_NO_REGISTROS, id)));
            ConsultasClientes consultasClientes = new ConsultasClientes(clienteFeign);
            Clientes clientesBody = consultasClientes.obtenerClientePorId(cuentas.getClienteId());
            CuentaDTO cuentasTranformadas = mapper.cuentasACuentaDto(cuentas);
            cuentasTranformadas.setClientes(clientesBody);
            return new ResponseEntity<>(cuentasTranformadas, HttpStatus.OK);
        }catch (NoSuchElementException e){
            log.error("Error en consultar Entidad id " + e);
            throw  new NoSuchElementException(e.getMessage());
        }catch (Exception e){
            log.error("Error en consultar Cuenta id " + e);
            throw  new RuntimeException(String.format(ConstatesMesajes.ERROR_SERVIDOR, ModulosEnum.CUENTAS));

        }
    }

    /**
     * @param creacionDTO
     * @return
     */
    @Transactional
    @Override
    public ResponseEntity<RespuestaDTO> crearCuenta(CuentaCreacionDTO creacionDTO) {
        try{
            //Validamos la existencia del cliente enviado
            if(clienteFeign.detalle(creacionDTO.getClienteId()).getStatusCode() != HttpStatus.OK) throw new NoSuchElementException(String.format(ConstatesMesajes.CLIENTE_NO_EXISTE,creacionDTO.getClienteId()));
            repository.save(mapper.cuentasDtoACuentaCreacion(creacionDTO));
            return new ResponseEntity<>(RespuestaDTO.builder().mensage(String.format(ConstatesMesajes.CREACION,ModulosEnum.CUENTAS)).build(), HttpStatus.CREATED);
        }catch (NoSuchElementException e){
            log.error("Error en consultar Entidad id " + e);
            throw  new NoSuchElementException(e.getMessage());
        }catch (Exception e){
            log.error("Error en crear Cuentas " + e);
            throw  new RuntimeException(String.format(ConstatesMesajes.ERROR_SERVIDOR, ModulosEnum.CUENTAS));

        }
    }

    /**
     * @param id
     * @param cuentaDTO
     * @return
     */
    @Transactional
    @Override
    public ResponseEntity<RespuestaDTO> actualizarCuenta(Long id, CuentaDTO cuentaDTO) {
        try{
            Cuentas cuentas = repository.findById(id).orElseThrow(() -> new NoSuchElementException(String.format(ConstatesMesajes.ERROR_NO_REGISTROS, id)));
            mapper.actualizarCuenta(cuentaDTO,cuentas);
            repository.save(cuentas);
            return new ResponseEntity<>(RespuestaDTO.builder().mensage(String.format(ConstatesMesajes.ACTUALIZAR,ModulosEnum.CUENTAS)).build(), HttpStatus.OK);
        }catch (NoSuchElementException e){
            log.error("Error en consultar Entidad id " + e);
            throw  new NoSuchElementException(e.getMessage());
        }catch (Exception e){
            log.error("Error en actualizar Cuentas " + e);
            throw  new RuntimeException(String.format(ConstatesMesajes.ERROR_SERVIDOR, ModulosEnum.CUENTAS));

        }
    }

    /**
     * @param id
     * @return
     */
    @Transactional
    @Override
    public ResponseEntity<RespuestaDTO> eliminarCuenta(Long id) {
        try{
            Cuentas cuentas = repository.findById(id).orElseThrow(() -> new NoSuchElementException(String.format(ConstatesMesajes.ERROR_NO_REGISTROS, id)));
            repository.delete(cuentas);
            return new ResponseEntity<>(RespuestaDTO.builder().build(), HttpStatus.NO_CONTENT);
        }catch (NoSuchElementException e){
            log.error("Error en consultar Entidad id " + e);
            throw  new NoSuchElementException(e.getMessage());
        }catch (Exception e){
            log.error("Error en eliminar Cuentas " + e);
            throw  new RuntimeException(String.format(ConstatesMesajes.ERROR_SERVIDOR, ModulosEnum.CUENTAS));

        }
    }

}
