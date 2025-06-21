package com.ducklibras.api.models.repo;

import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ducklibras.api.models.entitys.AlunoEntitys;

@Repository
public interface AlunoRepo extends JpaRepository<AlunoEntitys, Long> {
    
    Optional<AlunoEntitys> findByEmail(String email);

    Optional<AlunoEntitys> findByUsernameOrEmail(String email, String username);

    Optional<AlunoEntitys> findByUsername(String username);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    boolean existsByUsernameOrEmail(String email, String username);

    Optional<AlunoEntitys> findByEmailAndPass(String email, String pass);

    }

