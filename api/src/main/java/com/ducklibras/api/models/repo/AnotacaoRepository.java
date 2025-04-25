package com.ducklibras.api.models.repo;

import com.ducklibras.api.models.entitys.AnotacaoEntity;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface AnotacaoRepository extends JpaRepository<AnotacaoEntity, Long> {
    
    @Query("SELECT a FROM AnotacaoEntity a WHERE a.titulo = ?1")
        public Optional<AnotacaoEntity> findByTitulo(String titulo);
    
    public boolean existsByConteudo(String conteudo);

    @Query("SELECT a FROM AnotacaoEntity a WHERE (a.titulo = ?1) AND a.conteudo = ?2")
        public Optional<AnotacaoEntity> findByTituloAndConteudo(String titulo, String conteudo);
}
