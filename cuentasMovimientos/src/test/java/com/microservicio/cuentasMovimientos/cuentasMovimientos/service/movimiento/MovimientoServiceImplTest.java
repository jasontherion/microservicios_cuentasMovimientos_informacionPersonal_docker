package com.microservicio.cuentasMovimientos.cuentasMovimientos.service.movimiento;

import com.microservicio.cuentasMovimientos.cuentasMovimientos.Enum.TiposCuentasEnum;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.dto.CuentaDTO;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.dto.EntidadDTO;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.dto.MovimientoDTO;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.dto.RespuestaDTO;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.mapper.ICuentaMapper;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.mapper.IMovimeintoMapper;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.model.Cuentas;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.model.Movimientos;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.repository.ICuentaRepository;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.repository.IMovimientoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.microservicio.cuentasMovimientos.cuentasMovimientos.fabricaPruebas.FakeDataGenerator.createFakeCuentasDTO;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


class MovimientoServiceImplTest {

    @Mock
    IMovimientoRepository repositoryMovimientos;

    @Mock
    ICuentaMapper cuentaMapper;

    @Mock
    IMovimeintoMapper movimeintoMapper;

    @Mock
    ICuentaRepository cuentaRepository;

    @InjectMocks
    MovimientoServiceImpl movimientoService;

    List<CuentaDTO> cuentasDTO = createFakeCuentasDTO(5);



    @BeforeEach
    void init(){
        MockitoAnnotations.openMocks(this);
    }


//    @Test
//    void crearMovimiento() {
//        List<Movimientos> movimientos = new ArrayList<>();
//
//        CuentaDTO  cuentaTestDTO = cuentasDTO.get(0);
//        MovimientoDTO movimientoDTO = cuentasDTO.get(0).getMovimientos().get(0);
//        EntidadDTO entidadDTO = cuentasDTO.get(0).getEntidad();
//        movimientoDTO.setCuenta(cuentaTestDTO);
//        movimientoDTO.setEntidad(entidadDTO);
//
//
//        movimientos.add(Movimientos.builder()
//                                   .movimentoId(movimientoDTO.getMovimentoId())
//                                   .valor(200.00F)
//                                   .build());
//        Cuentas cuentasTest = Cuentas.builder()
//                                    .cuentaId(cuentaTestDTO.getCuentaId())
//                                    .movimientos(movimientos)
//                                    .saldoInicial(100000.00F)
//                .numeroCuenta(cuentaTestDTO.getNumeroCuenta())
//                .tipo(TiposCuentasEnum.AHORROS)
//                .estado(true)
//                                    .build();
//
//        when(cuentaMapper.cuentasDtoACuenta(cuentaTestDTO)).thenReturn(cuentasTest);
//        when(cuentaRepository.findById(cuentaTestDTO.getCuentaId())).thenReturn(Optional.ofNullable(cuentasTest));
//        when(repositoryMovimientos.save(movimeintoMapper.movimientosDtoAMovimientos(movimientoDTO))).thenReturn(movimientos.get(0));
//
//        ResponseEntity<RespuestaDTO> resultado = movimientoService.crearMovimiento(movimientoDTO);
//
//        assertEquals(HttpStatus.OK, resultado.getStatusCode());
//
//    }
}