package com.microservicio.cuentasMovimientos.cuentasMovimientos.service.reporte;


import com.microservicio.cuentasMovimientos.cuentasMovimientos.Enum.ModulosEnum;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.clientes.IInformacionClientesRest;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.dto.RangoFechaDTO;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.dto.ResporteDTO;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.dto.RespuestaDTO;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.mapper.ReporteMapper;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.model.Clientes;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.model.Cuentas;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.repository.IMovimientoRepository;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.utilidades.ConstatesMesajes;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.utilidades.ConsultasClientes;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@AllArgsConstructor
@Service
public class ReporteServiceImpl implements IReporteService{
    private final IInformacionClientesRest feign;
    private final IMovimientoRepository repository;
    private final ReporteMapper mapper;



    /**
     * @param rangoFechaDTO
     * @param cliente
     * @return
     */
    @Transactional(readOnly = true)
    @Override
    public ResponseEntity<RespuestaDTO> reportes(RangoFechaDTO rangoFechaDTO, Long clienteId) {
        try{
            List<Cuentas> cuentas = repository.consultarMovimientosFecha(rangoFechaDTO.getFechaInicial(), rangoFechaDTO.getFechaFinal(), clienteId);
            ConsultasClientes consultasClientes = new ConsultasClientes(feign);
            Clientes cliente = consultasClientes.obtenerClientePorId(clienteId);
            List<ResporteDTO> reportes = mapper.cuentasToReporteDTO(cuentas);
            reportes.forEach(reporte -> {
                reporte.setCliente(cliente.getPersona().getNombre());
            });
            return new ResponseEntity<>(RespuestaDTO.builder().mensage(String.format(ConstatesMesajes.LISTAR_REGISTROS, ModulosEnum.REPORTE)).data(reportes).build(), HttpStatus.OK);
        }catch (NoSuchElementException e){
            log.error("Error en reporte " + e);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format(ConstatesMesajes.ERROR_NO_REGISTROS), e);
        }catch (Exception e){
            log.error("Error en reporte " + e);
            throw  new RuntimeException(String.format(ConstatesMesajes.ERROR_SERVIDOR, ModulosEnum.REPORTE));

        }
    }
}
