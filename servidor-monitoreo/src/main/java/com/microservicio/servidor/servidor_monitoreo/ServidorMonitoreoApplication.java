package com.microservicio.servidor.servidor_monitoreo;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@EnableAdminServer
@SpringBootApplication
public class ServidorMonitoreoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServidorMonitoreoApplication.class, args);
	}

}
