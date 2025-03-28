package com.api.ducklibras.models.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.api.ducklibras.models.Entity.AlunoEntity;

@Repository
public interface AlunoRepo extends JpaRepository<AlunoEntity, Long> {

}