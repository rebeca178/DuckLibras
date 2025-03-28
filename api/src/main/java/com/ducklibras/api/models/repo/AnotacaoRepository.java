package com.ducklibras.api.models.repo;

import com.ducklibras.api.models.entitys.AnotacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AnotacaoRepository extends JpaRepository<AnotacaoEntity, Long> {
}
