package com.jzapata.lavado_service.service;

import com.jzapata.lavado_service.model.Lavado;
import com.jzapata.lavado_service.repository.LavadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class LavadoServiceImpl implements LavadoService{

    @Autowired
    private LavadoRepository lavadoRepository;
    @Override
    public List<Lavado> getAllLavados() {
        return lavadoRepository.findByEliminadoFalse() ;
    }

    @Override
    public Lavado saveLavado(Lavado lavado) {
        return lavadoRepository.save(lavado);
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
