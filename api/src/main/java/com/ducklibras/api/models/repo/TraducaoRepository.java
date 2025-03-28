package com.ducklibras.api.models.repositorios;

import com.ducklibras.api.models.entitys.TraducaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TraducaoRepository extends JpaRepository<TraducaoEntity, Long> {

    // Método para encontrar traduções por Dicionário
    List<TraducaoEntity> findByDicioId(Long dicioId);

    // Método para buscar uma tradução por ID
    Optional<TraducaoEntity> findById(Long id);

    // Método para excluir traduções por Dicionário
    void deleteByDicioId(Long dicioId);
}
