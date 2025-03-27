package com.api.ducklibras.models.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.ducklibras.models.Entity.AlunoEntity;

@Repository
public interface AlunoRepo extends JpaRepository<AlunoEntity, Long> {

    @Query("SELECT u FROM AlunoEntity u WHERE u.username = ?1 AND u.email = ?2")
    AlunoEntity findByUsernameAndEmail(String usename, String email);

}