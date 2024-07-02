package com.jzapata.lavado_service.repository;

import com.jzapata.lavado_service.model.Lavado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LavadoRepository extends JpaRepository<Lavado, Long> {
    List<Lavado> findByEliminadoFalse();
}
