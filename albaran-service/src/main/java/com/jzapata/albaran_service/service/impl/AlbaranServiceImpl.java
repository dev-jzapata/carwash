package com.jzapata.albaran_service.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jzapata.albaran_service.dto.ClienteDto;
import com.jzapata.albaran_service.dto.LavadoDto;
import com.jzapata.albaran_service.model.Albaran;
import com.jzapata.albaran_service.repository.AlbaranRepository;
import com.jzapata.albaran_service.service.AlbaranService;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.util.*;

@Slf4j
@Service
@Transactional
public class AlbaranServiceImpl implements AlbaranService {


    @Autowired
    private AlbaranRepository albaranRepository;


    @Override
    public List<Albaran> getAllAlbarans() {

        return albaranRepository.findAll();
    }

    @Override
    public Albaran save(Albaran albaran) {
        return albaranRepository.save(albaran);
    }

    @Override
    public Albaran getAlbaran(Long id) {

        return albaranRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteAlbaran(Long id) {
        try{
            albaranRepository.deleteById(id);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


}
