package com.jzapata.albaran_service.controller;

import com.jzapata.albaran_service.dto.AlbaranRequest;
import com.jzapata.albaran_service.dto.AlbaranResponse;
import com.jzapata.albaran_service.dto.ClienteDto;
import com.jzapata.albaran_service.dto.LavadoDto;
import com.jzapata.albaran_service.model.Albaran;
import com.jzapata.albaran_service.service.AlbaranService;
import com.jzapata.albaran_service.service.KafkaAlbaranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/albaranes")
public class AlbaranController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private AlbaranService albaranService;

    @Autowired
    private KafkaAlbaranService kafkaAlbaranService;

    public AlbaranController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public ResponseEntity<List<Albaran>> getAllAlbaranes(){
        return ResponseEntity.ok().body(albaranService.getAllAlbarans());
    }

    @GetMapping("/new")
    public ResponseEntity<AlbaranResponse> newAlbaran(){

        AlbaranResponse albaranResponse = new AlbaranResponse();

        kafkaAlbaranService.enviarPeticion("lavados-request-topic", "all");
        List<Object> lavadoDtoList = kafkaAlbaranService.recibirListaDtos("lavados-topic");

        @SuppressWarnings("unchecked")
        List<LavadoDto> lavadoDtos = (List<LavadoDto>) (List<?>) lavadoDtoList;

        kafkaAlbaranService.enviarPeticion("clientes-request-topic", "all");
        List<Object> clienteDtoList = kafkaAlbaranService.recibirListaDtos("clientes-topic");

        @SuppressWarnings("unchecked")
        List<ClienteDto> clienteDtos = (List<ClienteDto>) (List<?>) clienteDtoList;

        albaranResponse.setFecha(LocalDate.now());
        albaranResponse.setAllLavados(lavadoDtos);
        albaranResponse.setAllClientes(clienteDtos);
        albaranResponse.setLavados(null);

        return ResponseEntity.ok().body(albaranResponse);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<Albaran> saveAlbaran(@RequestBody AlbaranRequest request){

        Albaran albaran = new Albaran();

        albaran.setId(request.getId());
        albaran.setFecha(request.getFecha());
        albaran.setLavados(request.getLavados());
        albaran.setCliente(request.getClienteDto().getId());

        albaranService.save(albaran);

        return ResponseEntity.status(HttpStatus.CREATED).body(albaran);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public ResponseEntity<AlbaranResponse> getAlbaran(@PathVariable Long id){

        Albaran albaran = albaranService.getAlbaran(id);

        AlbaranResponse albaranResponse = new AlbaranResponse();

        kafkaAlbaranService.enviarPeticion("lavados-request-topic", "all");
        List<Object> lavadoDtoList = kafkaAlbaranService.recibirListaDtos("lavados-topic");

        @SuppressWarnings("unchecked")
        List<LavadoDto> lavadoDtos = (List<LavadoDto>) (List<?>) lavadoDtoList;

        kafkaAlbaranService.enviarPeticion("clientes-request-topic", "all");
        List<Object> clienteDtoList = kafkaAlbaranService.recibirListaDtos("clientes-topic");

        @SuppressWarnings("unchecked")
        List<ClienteDto> clienteDtos = (List<ClienteDto>) (List<?>) clienteDtoList;

        albaranResponse.setId(albaran.getId());
        albaranResponse.setFecha(albaran.getFecha());
        albaranResponse.setLavados(albaran.getLavados());
        albaranResponse.setFecha(albaran.getFecha());
        albaranResponse.setAllLavados(lavadoDtos);
        albaranResponse.setAllClientes(clienteDtos);
        albaranResponse.setCliente(albaran.getCliente());

        return ResponseEntity.ok().body(albaranResponse);

    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public ResponseEntity<AlbaranResponse>deleteAlbaran(@PathVariable Long id){
        albaranService.deleteAlbaran(id);

        AlbaranResponse albaranResponse = new AlbaranResponse();

        albaranResponse.setMensaje("Albaran eliminado!");

        return ResponseEntity.ok().body(albaranResponse);
    }



}
