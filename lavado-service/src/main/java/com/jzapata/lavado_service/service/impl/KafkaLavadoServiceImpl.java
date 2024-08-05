package com.jzapata.lavado_service.service.impl;

import com.jzapata.lavado_service.model.Lavado;
import com.jzapata.lavado_service.repository.LavadoRepository;
import com.jzapata.lavado_service.service.KafkaLavadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KafkaLavadoServiceImpl implements KafkaLavadoService {

    private final KafkaTemplate<String, List<Lavado>> kafkaTemplate;

    @Autowired
    private LavadoRepository lavadoRepository;

    @Autowired
    public KafkaLavadoServiceImpl(KafkaTemplate<String, List<Lavado>> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void sendLavados(String topic, List<Lavado> lavados) {
        kafkaTemplate.send(topic, lavados);
    }

    @Override
    public List<Lavado> loadLavados(String receivedString) {

        List<Lavado> lavados = new ArrayList<>();

        if (receivedString.equals("all")){
            lavados = lavadoRepository.findAll();
        }
        System.out.println("Lista Lavados: "+ lavados);
        return lavados;
    }
}


