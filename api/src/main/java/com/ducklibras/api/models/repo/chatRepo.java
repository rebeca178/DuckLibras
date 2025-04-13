package com.ducklibras.api.models.repo;

import com.ducklibras.api.models.entitys.chatEntitys;

import lombok.NonNull;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@NonNull
@Repository
public interface chatRepo extends JpaRepository<chatEntitys, Long> {
   
  
}
