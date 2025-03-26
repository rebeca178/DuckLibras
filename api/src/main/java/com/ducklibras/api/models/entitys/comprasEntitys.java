package com.ducklibras.api.models.entitys;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "compras")
public class comprasEntitys {
    
    private static final long serialVersionUID = 1L;
   
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "quantidade", nullable = false, length = 255)
    private String quantidade;

    @OneToMany
    @JoinColumn(name = "Id_loja" , nullable = false)
    private lojaEntitys loja;

    @OneToMany
    @JoinColumn(name = "Id_al" , nullable = false)
    private alEntitys aluno;

    public comprasEntitys() {
    }
}
