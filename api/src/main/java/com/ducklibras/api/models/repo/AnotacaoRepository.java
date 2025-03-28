package com.ducklibras.api.models.repo;

import com.ducklibras.api.models.entitys.AnotacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AnotacaoRepository extends JpaRepository<AnotacaoEntity, Long> {

    // Método para encontrar todas as anotações por Dicionário
    List<AnotacaoEntity> findByDicioId(Long dicioId);

    // Método para buscar uma anotação por ID
    Optional<AnotacaoEntity> findById(Long id);

    // Método para buscar todas as anotações associadas a um BS
    List<AnotacaoEntity> findByBsId(Long bsId);

    // Método para excluir anotações por Dicionário
    void deleteByDicioId(Long dicioId);
}
