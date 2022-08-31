package com.nttdata.bootcamp.batch.general;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class BatchGeneralApplication implements CommandLineRunner {

	/** Declaración de la variable de log */
	private static final Logger log = LogManager.getLogger(BatchGeneralApplication.class);

	/** Creación del método main y sus argumentos */
	public static void main(String[] args) {

		SpringApplication.run(BatchGeneralApplication.class, args);

	}

	/** Creación del método run y sus argumentos */
	@Override
	public void run(String... args) throws Exception {
		log.info("Init Project");
		log.warn("warning de prueba");
		log.error("erro de prueba");
	}

}