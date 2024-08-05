package com.jzapata.clientes.controller;

import com.jzapata.clientes.entity.Cliente;
import com.jzapata.clientes.service.impl.KafkaClienteServiceImpl;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KafkaClienteController {

    private final KafkaClienteServiceImpl kafkaCLienteService;

    public KafkaClienteController(KafkaClienteServiceImpl kafkaCLienteService){
        this.kafkaCLienteService = kafkaCLienteService;
    }

    @KafkaListener(topics = "clientes-request-topic", groupId = "my-group")
    public void listen(String message) {

        List<Cliente> clientes = kafkaCLienteService.loadClientes(message);

        kafkaCLienteService.sendClientes("clientes-topic", clientes);
    }

    @PostMapping("/sendClientes")
    public void sendClientes(@RequestBody List<Cliente> clientes) {
        kafkaCLienteService.sendClientes("clientes-topic", clientes);
    }

}
