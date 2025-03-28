package com.ducklibras.api.models.repositorios;

import com.ducklibras.api.models.entitys.AnotacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnotacaoRepository extends JpaRepository<AnotacaoEntity, Long> {

    // Método para encontrar todas as anotações por título
    List<AnotacaoEntity> findByTitulo(String titulo);

    // Método para encontrar anotações por conteúdo (utilizando 'like' para buscas parciais)
    List<AnotacaoEntity> findByConteudoContaining(String conteudo);

    // Método para encontrar anotações que possuem um título específico e ordená-las por data (descendente)
    List<AnotacaoEntity> findByTituloOrderByDataCriacaoDesc(String titulo);

    // Método para encontrar anotações por conteúdo e ordenar por título (ascendente)
    List<AnotacaoEntity> findByConteudoContainingOrderByTituloAsc(String conteudo);
    
    // Método para contar o número de anotações com um determinado título
    long countByTitulo(String titulo);

    // Método para excluir anotações por título
    void deleteByTitulo(String titulo);
}
