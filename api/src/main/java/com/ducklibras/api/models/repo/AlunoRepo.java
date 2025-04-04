package com.ducklibras.api.models.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ducklibras.api.models.entitys.AlunoEntitys;

@Repository
public interface AlunoRepo extends JpaRepository<AlunoEntitys, Long> {
    
    @Query("SELECT a FROM AlunoEntitys a WHERE a.username = ?1 AND a.email = ?2")
    public Optional<AlunoEntitys> findByUsernameAndEmail(String username, String email);

}
