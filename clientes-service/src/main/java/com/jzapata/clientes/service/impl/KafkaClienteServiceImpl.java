package com.jzapata.clientes.service.impl;

import com.jzapata.clientes.entity.Cliente;
import com.jzapata.clientes.repository.ClienteRepository;
import com.jzapata.clientes.service.KafkaClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KafkaClienteServiceImpl implements KafkaClienteService {

    private final KafkaTemplate<String, List<Cliente>> kafkaTemplate;

    @Autowired
    private ClienteRepository clienteRepository;


    @Autowired
    public KafkaClienteServiceImpl(KafkaTemplate<String, List<Cliente>> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public List<Cliente> loadClientes(String receivedString){
        List<Cliente> clientes = new ArrayList<>();
        System.out.println("Recibiendo respuesta: " + receivedString);
        if (receivedString.equals("all")){
            clientes = clienteRepository.findAll();
        }

        return clientes;
    }

    @Override
    public void sendClientes(String topic, List<Cliente> clientes){
        kafkaTemplate.send(topic, clientes);
    }

}
