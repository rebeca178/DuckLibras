package com.ducklibras.api.models.repo;

import com.ducklibras.api.models.entitys.AnotacaoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface AnotacaoRepository extends JpaRepository<AnotacaoEntity, Long> {

    List<AnotacaoEntity> findByTituloIgnoreCase(String titulo);

    @Query("SELECT a FROM AnotacaoEntity a WHERE LOWER(a.conteudo) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<AnotacaoEntity> searchByKeyword(String keyword);

    // Busca por usuário (exemplo: pegar todas as anotações de um usuário específico)
    List<AnotacaoEntity> findByUsuarioId(Long usuarioId);

    Page<AnotacaoEntity> findAll(Pageable pageable);

    Optional<AnotacaoEntity> findById(Long id);
}
