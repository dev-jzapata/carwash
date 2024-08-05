package com.jzapata.albaran_service.service;

import com.jzapata.albaran_service.dto.ClienteDto;
import com.jzapata.albaran_service.dto.LavadoDto;

import java.util.List;

public interface KafkaAlbaranService {

    public void enviarPeticion(String topic, String message);
    public List<Object> recibirListaDtos(String topic);

}
