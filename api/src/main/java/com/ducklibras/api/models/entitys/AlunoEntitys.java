package com.ducklibras.api.models.entitys;


import java.util.List;
import jakarta.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name = "aluno", uniqueConstraints = 
            {
        @UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "email")
            }
        )
public class AlunoEntitys{

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id; 
    
    @Column(name = "username", nullable = false, length = 255)
    private String username;
     
    @Column(name = "pass", nullable = false, length = 160)
    private String pass;
    
    @Column(name = "email", nullable = false, length = 160)
    private String email;

    @Column(name = "photo", nullable = true, length = 160)
    private String photo;

    public AlunoEntitys() {
    }
    
}