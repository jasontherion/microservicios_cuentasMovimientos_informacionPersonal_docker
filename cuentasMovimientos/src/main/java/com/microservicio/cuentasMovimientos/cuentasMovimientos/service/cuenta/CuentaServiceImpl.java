package com.microservicio.cuentasMovimientos.cuentasMovimientos.service.cuenta;


import com.microservicio.cuentasMovimientos.cuentasMovimientos.Enum.ModulosEnum;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.clientes.IInformacionClientesRest;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.dto.CuentaDTO;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.mapper.ICuentaMapper;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.model.Clientes;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.repository.ICuentaRepository;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.utilidades.ConstatesMesajes;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@AllArgsConstructor
@Slf4j
@Service
public class CuentaServiceImpl implements ICuentaService {


    private final IInformacionClientesRest clienteFeign;
    private final ICuentaMapper mapper;
    private final ICuentaRepository repository;

    @Autowired
    public List<Clientes> findAll() {
        return clienteFeign.listar().stream().collect(Collectors.toList());
    }

    /**
     * @return
     */
    @Override
    public ResponseEntity<List<CuentaDTO>> listarCuentas() {
        try{
            return null;
        }catch (Exception e){
            log.error("Error en listar Cuentas " + e);
            throw  new RuntimeException(String.format(ConstatesMesajes.ERROR_SERVIDOR, ModulosEnum.CUENTAS));

        }
    }

    /**
     * @param id
     * @return
     */
    @Override
    public ResponseEntity<CuentaDTO> consultarCuentaId(Long id) {
        try{
            return null;
        }catch (Exception e){
            log.error("Error en consultar Cuenta id " + e);
            throw  new RuntimeException(String.format(ConstatesMesajes.ERROR_SERVIDOR, ModulosEnum.CUENTAS));

        }
    }

    /**
     * @param cuentaDTO
     * @return
     */
    @Override
    public ResponseEntity<String> crearCuenta(CuentaDTO cuentaDTO) {
        try{
            return null;
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
    @Override
    public ResponseEntity<String> actualizarCuenta(Long id, CuentaDTO cuentaDTO) {
        try{
            return null;
        }catch (Exception e){
            log.error("Error en actualizar Cuentas " + e);
            throw  new RuntimeException(String.format(ConstatesMesajes.ERROR_SERVIDOR, ModulosEnum.CUENTAS));

        }
    }

    /**
     * @param id
     * @return
     */
    @Override
    public ResponseEntity<String> eliminarCuenta(Long id) {
        try{
            return null;
        }catch (Exception e){
            log.error("Error en eliminar Cuentas " + e);
            throw  new RuntimeException(String.format(ConstatesMesajes.ERROR_SERVIDOR, ModulosEnum.CUENTAS));

        }
    }

}
