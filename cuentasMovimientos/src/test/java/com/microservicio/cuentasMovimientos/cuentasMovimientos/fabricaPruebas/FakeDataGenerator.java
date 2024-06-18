package com.microservicio.cuentasMovimientos.cuentasMovimientos.fabricaPruebas;

import com.github.javafaker.Faker;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.Enum.TipoMovimientoEnum;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.Enum.TiposCuentasEnum;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.dto.CuentaDTO;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.dto.EntidadDTO;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.dto.MovimientoDTO;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.model.Cuentas;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.model.Entidades;
import com.microservicio.cuentasMovimientos.cuentasMovimientos.model.Movimientos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class FakeDataGenerator {
    private static final Faker faker = new Faker();

    public static List<CuentaDTO> createFakeCuentasDTO(int numberOfCuentas) {
        List<CuentaDTO> cuentas = new ArrayList<>();
        for (int i = 0; i < numberOfCuentas; i++) {
            CuentaDTO cuenta = CuentaDTO.builder()
                    .cuentaId((long) i + 1)
                    .numeroCuenta(faker.finance().creditCard())
                    .tipo(faker.options().option("AHORROS", "CORRIENTE"))
                    .saldoInicial(faker.number().randomNumber(5, true) / 100.0f)
                    .estado(faker.bool().bool())
                    .entidad(createFakeEntidadDTO())
                    .movimientos(createFakeMovimientosDTO(3)) // Genera 3 movimientos por cuenta
                    .build();
            cuentas.add(cuenta);
        }
        return cuentas;
    }

    public static EntidadDTO createFakeEntidadDTO() {
        EntidadDTO entidad = EntidadDTO.builder()
                .entidadId(faker.number().randomNumber(5, true))
                .nombre(faker.company().name())
                .cuentas(new ArrayList<>()) // Esto puede ser completado posteriormente
                .movimientos(new ArrayList<>()) // Esto puede ser completado posteriormente
                .build();
        return entidad;
    }

    public static List<MovimientoDTO> createFakeMovimientosDTO(int numberOfMovimientos) {
        List<MovimientoDTO> movimientos = new ArrayList<>();
        for (int i = 0; i < numberOfMovimientos; i++) {
            MovimientoDTO movimiento = MovimientoDTO.builder()
                    .movimentoId(faker.number().randomNumber(5, true))
                    .fecha(LocalDate.now().minusDays(faker.number().numberBetween(0, 30)))
                    .tipoMovimiento(faker.options().option("DEPOSITO", "RETIRO"))
                    .valor(faker.number().randomNumber(5, true) / 100.0f)
                    .saldo(faker.number().randomNumber(5, true) / 100.0f)
                    .entidad(createFakeEntidadDTO()) // Referencia a la entidad ficticia
                    .cuenta(null)
                    .build();
            movimientos.add(movimiento);
        }
        return movimientos;
    }

    /*
    Metodos fake entidades
     */

    public static List<Cuentas> createFakeCuentas(int numberOfCuentas) {
        List<Cuentas> cuentas = new ArrayList<>();
        for (int i = 0; i < numberOfCuentas; i++) {
            Cuentas cuenta = Cuentas.builder()
                    .cuentaId((long) i + 1)
                    .numeroCuenta(faker.finance().creditCard())
                    .tipo(TiposCuentasEnum.AHORROS)
                    .saldoInicial(faker.number().randomNumber(5, true) / 100.0f)
                    .estado(faker.bool().bool())
                    .entidad(createFakeEntidades())
                    .movimientos(createFakeMovimientos(3)) // Genera 3 movimientos por cuenta
                    .build();
            cuentas.add(cuenta);
        }
        return cuentas;
    }

    public static Entidades createFakeEntidades() {
        Entidades entidad = Entidades.builder()
                .entidadId(faker.number().randomNumber(5, true))
                .nombre(faker.company().name())
                .cuentas(new ArrayList<>()) // Esto puede ser completado posteriormente
                .movimientos(new ArrayList<>()) // Esto puede ser completado posteriormente
                .build();
        return entidad;
    }

    public static List<Movimientos> createFakeMovimientos(int numberOfMovimientos) {
        List<Movimientos> movimientos = new ArrayList<>();
        for (int i = 0; i < numberOfMovimientos; i++) {
            Movimientos movimiento = Movimientos.builder()
                    .movimentoId(faker.number().randomNumber(5, true))
                    .fecha(LocalDate.now().minusDays(faker.number().numberBetween(0, 30)))
                    .tipoMovimiento(TipoMovimientoEnum.DEPOSITO)
                    .valor(faker.number().randomNumber(5, true) / 100.0f)
                    .saldo(faker.number().randomNumber(5, true) / 100.0f)
                    .entidad(createFakeEntidades()) // Referencia a la entidad ficticia
                    .cuentas(null) // Puede ser actualizado posteriormente para enlazar con la cuenta
                    .build();
            movimientos.add(movimiento);
        }
        return movimientos;
    }
}
