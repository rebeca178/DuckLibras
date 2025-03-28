package com.ducklibras.api.models.repo;

import com.ducklibras.api.models.entitys.chatEntitys;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface chatRepo extends JpaRepository<chatEntitys, Long> {
    
    // Aqui você pode adicionar métodos personalizados, se necessário.
    // Por exemplo:
    // List<chatEntitys> findByRemetenteId(Long remetenteId);
    
    // Outros métodos de consulta podem ser adicionados aqui.

 
  
  
}
