package com.ducklibras.api.models.entitys;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "loja")
public class lojaEntitys {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "produto", nullable = false, length = 255)
    private String produto;

    @Column(name = "preco", nullable = false, length = 11)
    private int preco;
    
    public lojaEntitys() {
    }
}
