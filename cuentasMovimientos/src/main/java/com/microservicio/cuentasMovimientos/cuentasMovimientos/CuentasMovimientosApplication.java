package com.microservicio.cuentasMovimientos.cuentasMovimientos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class CuentasMovimientosApplication {

	public static void main(String[] args) {
		SpringApplication.run(CuentasMovimientosApplication.class, args);
	}

}
