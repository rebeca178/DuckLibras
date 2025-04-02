package com.ducklibras.api.models.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ducklibras.api.models.entitys.CompraEntitys;

@Repository
public interface comprasRepo extends JpaRepository<CompraEntitys, Long> {
    
    // Aqui você pode adicionar métodos personalizados, se necessário.
    // Por exemplo:
    // List<comprasEntitys> findByLojaId(Long lojaId);
    
    // Outros métodos de consulta podem ser adicionados aqui.

    
} 