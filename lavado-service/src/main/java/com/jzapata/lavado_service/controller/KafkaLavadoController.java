package com.jzapata.lavado_service.controller;

import com.jzapata.lavado_service.model.Lavado;
import com.jzapata.lavado_service.service.impl.KafkaLavadoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KafkaLavadoController {

    private final KafkaLavadoServiceImpl kafkaService;

    @Autowired
    public KafkaLavadoController(KafkaLavadoServiceImpl kafkaService) {
        this.kafkaService = kafkaService;
    }

    @KafkaListener(topics = "lavados-request-topic", groupId = "my-group")
    public void listen(String message) {
        System.out.println("Mensaje: "+ message);

        List<Lavado> lavados = kafkaService.loadLavados(message);
        System.out.println("Enviando lavados:" + lavados);
        kafkaService.sendLavados("lavados-topic", lavados);
    }

    @PostMapping("/sendLavados")
    public void sendLavados(@RequestBody List<Lavado> lavados) {
        System.out.println("Lista Lavados: "+ lavados);
        kafkaService.sendLavados("lavados-topic", lavados);
    }

}
