package com.jzapata.albaran_service.repository;

import com.jzapata.albaran_service.model.Albaran;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbaranRepository extends JpaRepository<Albaran, Long> {
}
