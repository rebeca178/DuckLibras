package com.ducklibras.api.models.repositorios;

import com.ducklibras.api.models.entitys.TraducaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TraducaoRepository extends JpaRepository<TraducaoEntity, Long> {

    // Método para encontrar todas as traduções por idioma de origem
    List<TraducaoEntity> findByIdiomaOrigem(String idiomaOrigem);

    // Método para encontrar traduções por texto original (utilizando 'like' para buscas parciais)
    List<TraducaoEntity> findByTextoOriginalContaining(String textoOriginal);

    // Método para encontrar traduções por idioma de origem e idioma de destino
    List<TraducaoEntity> findByIdiomaOrigemAndIdiomaDestino(String idiomaOrigem, String idiomaDestino);

    // Método para contar o número de traduções com um determinado idioma de origem
    long countByIdiomaOrigem(String idiomaOrigem);

    // Método para excluir traduções por idioma de origem
    void deleteByIdiomaOrigem(String idiomaOrigem);
}
