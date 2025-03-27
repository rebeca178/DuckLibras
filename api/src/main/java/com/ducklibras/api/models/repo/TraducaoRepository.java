package com.ducklibras.api.models.repo;

import com.ducklibras.api.models.entitys.Traducao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TraducaoRepository extends JpaRepository<Traducao, Long> {
}
