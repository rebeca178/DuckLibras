package com.ducklibras.api.models.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.ducklibras.api.models.entitys.AlunoEntitys;

@Repository
public interface AlunoRepo extends JpaRepository<AlunoEntitys, Long> {

}
