package com.ducklibras.api.models.repo;

import com.ducklibras.api.models.entitys.TraducaoEntity;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TraducaoRepository extends JpaRepository<TraducaoEntity, Long> {
    

}