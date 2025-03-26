package com.ducklibras.api.models.entitys;

import java.io.Serializable;

import com.ducklibras.api.models.entitys.BsDtos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "BS")
public class BsDtos implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Column(name = "status", nullable = false, columnDefinition = "boolean")
    private String status;

    


    

}
