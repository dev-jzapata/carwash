package com.jzapata.albaran_service.controller;

import com.jzapata.albaran_service.dto.AlbaranRequest;
import com.jzapata.albaran_service.dto.AlbaranResponse;
import com.jzapata.albaran_service.model.Albaran;
import com.jzapata.albaran_service.repository.AlbaranRepository;
import com.jzapata.albaran_service.service.AlbaranService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/albaranes")
public class AlbaranController {


    @Autowired
    private AlbaranService albaranService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public ResponseEntity<List<Albaran>> getAllAlbaranes(){
        return ResponseEntity.ok().body(albaranService.getAllAlbarans());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<Albaran> saveAlbaran(@RequestBody AlbaranRequest request){
        Albaran albaran = new Albaran();
        albaran.setFecha(request.getFecha());
        albaran.setLavados(request.getLavados());

        return ResponseEntity.status(HttpStatus.CREATED).body(albaran);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public ResponseEntity<AlbaranResponse> getAlbaran(@PathVariable Long id){

        AlbaranResponse albaranResponse = new AlbaranResponse();
        Albaran albaran = albaranService.getAlbaran(id);
        albaranResponse.setId(albaran.getId());
        albaranResponse.setLavados(albaran.getLavados());

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
