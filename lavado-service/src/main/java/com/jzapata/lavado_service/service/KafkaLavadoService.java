package com.jzapata.lavado_service.service;

import com.jzapata.lavado_service.model.Lavado;

import java.util.List;

public interface KafkaLavadoService {
    public void sendLavados(String topic, List<Lavado> lavados);

    public List<Lavado> loadLavados(String receivedString);
}
