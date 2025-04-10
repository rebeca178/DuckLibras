package com.ducklibras.api.models.repo;

import com.ducklibras.api.models.entitys.TraducaoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface TraducaoRepository extends JpaRepository<TraducaoEntity, Long> {

    List<TraducaoEntity> findByTermoIgnoreCase(String termo);

    List<TraducaoEntity> findByIdioma(String idioma);

    List<TraducaoEntity> findByUsuarioId(Long usuarioId);

    @Query("SELECT t FROM TraducaoEntity t WHERE LOWER(t.conteudo) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<TraducaoEntity> searchByKeyword(String keyword);

    Page<TraducaoEntity> findAll(Pageable pageable);

    Optional<TraducaoEntity> findById(Long id);
}
