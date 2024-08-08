package com.jzapata.lavado_service.controller;

import com.jzapata.lavado_service.dto.LavadoRequest;
import com.jzapata.lavado_service.dto.LavadoResponse;
import com.jzapata.lavado_service.model.Lavado;
import com.jzapata.lavado_service.service.LavadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lavados")
public class LavadoController {

    @Autowired
    private LavadoService lavadoService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    @PreAuthorize("hasRole('admin_client_role')")
    public ResponseEntity<List<Lavado>> getAllLavados(){
        return ResponseEntity.ok().body(lavadoService.getAllLavados());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<Lavado> saveLavado(@RequestBody LavadoRequest lavadoDto){
            Lavado lavado = new Lavado();
            lavado.setNombre(lavadoDto.getNombre());
            lavadoService.saveLavado(lavado);
            return ResponseEntity.status(HttpStatus.CREATED).body(lavado);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public ResponseEntity<LavadoResponse> getLavado(@PathVariable Long id){

        LavadoResponse lavadoResponse = new LavadoResponse();
        Lavado lavado = lavadoService.getLavado(id).orElse(null);
        lavadoResponse.setId(lavado.getId());
        lavadoResponse.setNombre(lavado.getNombre());

        return ResponseEntity.ok().body(lavadoResponse);

    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public ResponseEntity<LavadoResponse>deleteLavado(@PathVariable Long id){
        lavadoService.deleteLavado(id);

        LavadoResponse lavadoResponse = new LavadoResponse();

        lavadoResponse.setMensaje("Lavado eliminado!");

        return ResponseEntity.ok().body(lavadoResponse);
    }

}
