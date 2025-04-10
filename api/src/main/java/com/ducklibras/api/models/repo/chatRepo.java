package com.ducklibras.api.models.repo;

import com.ducklibras.api.models.entitys.chatEntitys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface chatRepo extends JpaRepository<chatEntitys, Long> {
    List<chatEntitys> findByRemetenteAndDestinatario(String remetente, String destinatario);
  
}
