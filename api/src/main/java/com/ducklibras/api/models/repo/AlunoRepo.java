package com.ducklibras.api.models.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ducklibras.api.models.entitys.AlunoEntitys;

@Repository
public interface AlunoRepo extends JpaRepository<AlunoEntitys, Long> {
    
    @Query("SELECT a FROM AlunoEntitys a WHERE a.email = ?2")
    public Optional<AlunoEntitys> findByEmail(String email);

    @Query("SELECT COUNT(u) > 0 FROM AlunoEntitys a WHERE a.email = ?1")
    public boolean existsByEmail(String Email);

    @Query("SELECT a FROM AlunoEntitys a WHERE (a.email = ?1) AND a.pass = ?2")
    public Optional<AlunoEntitys> findByEmailAndPass(String email, String pass);

    }

