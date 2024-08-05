package com.jzapata.albaran_service.service.impl;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class KafkaAlbaranServiceImpl implements com.jzapata.albaran_service.service.KafkaAlbaranService {

    private final ConsumerFactory<String, Object> consumerFactory;
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public KafkaAlbaranServiceImpl(KafkaTemplate<String, String> kafkaTemplate, ConsumerFactory<String
            , Object> consumerFactory) {
        this.kafkaTemplate = kafkaTemplate;
        this.consumerFactory = consumerFactory;
    }

    @Override
    public void enviarPeticion(String topic, String message) {

        kafkaTemplate.send(topic, message);
    }

    @Override
    public List<Object> recibirListaDtos(String topic) {
        System.out.println("Recibiendo Datos en AlbaranService");
        List<Object> list = new ArrayList<>();

        Consumer<String, Object> consumer = consumerFactory.createConsumer();
        consumer.subscribe(Collections.singletonList(topic));
        ConsumerRecords<String, Object> records = consumer.poll(Duration.ofSeconds(10));
        consumer.close();


        for (ConsumerRecord<String, Object> record : records) {

            list.add(record.value());
            System.out.println(record.value());
        }

        return list;
    }

}
