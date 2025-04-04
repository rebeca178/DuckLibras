package com.ducklibras.api.models.entitys;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "compras")
public class CompraEntitys implements Serializable {
    
    private static final long serialVersionUID = 1L;
   
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "quantidade", nullable = false, length = 160)
    private int quantidade;

    @ManyToOne
    @JoinColumn(name = "lojaId", nullable = false)
    private lojaEntitys loja;

    public CompraEntitys() {
    }
}
