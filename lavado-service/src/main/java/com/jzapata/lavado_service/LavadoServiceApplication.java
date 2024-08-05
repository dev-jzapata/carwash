package com.jzapata.lavado_service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@Slf4j
@SpringBootApplication
public class LavadoServiceApplication {



	public static void main(String[] args) {
		SpringApplication.run(LavadoServiceApplication.class, args);
	}



}
