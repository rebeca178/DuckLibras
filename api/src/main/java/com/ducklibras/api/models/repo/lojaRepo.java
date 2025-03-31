package com.ducklibras.api.models.repo;

import org.springframework.stereotype.Repository;
import com.ducklibras.api.models.entitys.lojaEntitys;


@Repository
public interface lojaRepo extends org.springframework.data.jpa.repository.JpaRepository<lojaEntitys, Long> {
    // Aqui você pode adicionar métodos personalizados, se necessário.
    // Por exemplo:
    // List<lojaEntitys> findByProduto(String produto);
    
    // Outros métodos de consulta podem ser adicionados aqui.
}