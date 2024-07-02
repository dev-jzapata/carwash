package com.jzapata.lavado_service.service;

import com.jzapata.lavado_service.model.Lavado;

import java.util.List;
import java.util.Optional;

public interface LavadoService {

    public List<Lavado> getAllLavados();

    public Lavado saveLavado(Lavado lavado);

    public Optional<Lavado> getLavado(Long id);

    public void deleteLavado(Long id);

}
