package com.ducklibras.api.models.repo;

import com.ducklibras.api.models.entitys.Anotacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnotacaoRepository extends JpaRepository<Anotacao, Long> {
}
