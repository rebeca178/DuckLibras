package com.ducklibras.api.models.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ducklibras.api.models.entitys.BsEntitys;

@Repository
public interface BsRepo extends JpaRepository<BsEntitys, Long> {

}