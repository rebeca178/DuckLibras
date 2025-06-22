package com.ducklibras.api.models.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import com.ducklibras.api.models.entitys.PontuacaoEntity;

@Repository
public interface PontuacaoRepo extends JpaRepository<PontuacaoEntity, Long> {

    Optional<PontuacaoEntity> findByAlunoId(Long alunoId);

}