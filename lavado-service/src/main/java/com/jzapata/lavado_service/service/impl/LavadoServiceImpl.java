package com.jzapata.lavado_service.service.impl;

import com.jzapata.lavado_service.model.Lavado;
import com.jzapata.lavado_service.repository.LavadoRepository;
import com.jzapata.lavado_service.service.LavadoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

@Service
@Slf4j
public class LavadoServiceImpl implements LavadoService {

    private final KafkaTemplate<String, List<Lavado>> kafkaTemplate;

    private final ConsumerFactory<String, String> consumerFactory;
    @Autowired
    private LavadoRepository lavadoRepository;

    @Autowired
    public LavadoServiceImpl(KafkaTemplate<String, List<Lavado>> kafkaTemplate
            , ConsumerFactory<String, String> consumerFactory) {
        this.kafkaTemplate = kafkaTemplate;
        this.consumerFactory = consumerFactory;
    }

    @Override
    public List<Lavado> getAllLavados() {
        return lavadoRepository.findByEliminadoFalse() ;
    }


    @Override
    public Lavado saveLavado(Lavado lavadoRequest) {

        lavadoRepository.save(lavadoRequest);

        return lavadoRequest;
    }

    @Override
    public Optional<Lavado> getLavado(Long id) {
        return lavadoRepository.findById(id);
    }

    @Override
    public void deleteLavado(Long id) {

        try {
            lavadoRepository.deleteById(id);

        } catch (Exception e) {

            Lavado lavado = lavadoRepository.findById(id).orElse(null);
            if (lavado != null) {
                lavado.setEliminado(true);
                lavadoRepository.save(lavado);

            }
        }
    }
}
