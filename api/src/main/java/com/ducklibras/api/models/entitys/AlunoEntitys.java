package com.ducklibras.api.models.entitys;


import java.io.Serializable;

import com.ducklibras.api.models.dtos.AlunoInDto;

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
@Table(name = "aluno")
public class AlunoEntitys implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id; 
    
    @Column(name = "username", nullable = false, length = 255)
    private String username;
     
    @Column(name = "pass", nullable = false, length = 160)
    private String pass;
    
    @Column(name = "email", nullable = false, length = 160)
    private String email;

    @Column(name = "photo", nullable = false, length = 160)
    private String photo;

    public AlunoEntitys() {
    }

    public AlunoEntitys(Long id, String username, String pass, String email, String photo) {
        if (id != null) this.id = id;
        if (username != null) this.username = username;
        if (pass != null) this.pass = pass;
        if (email != null) this.email = email;
        if (photo != null) this.photo = photo;
    }
    public AlunoEntitys(String username, String pass, String email, String photo) {
        if (username != null) this.username = username;
        if (pass != null) this.pass = pass;
        if (email != null) this.email = email;
        if (photo != null) this.photo = photo;
    }
    public AlunoEntitys(String username, String pass, String email) {
        if (username != null) this.username = username;
        if (pass != null) this.pass = pass;
        if (email != null) this.email = email;
    }

    public AlunoEntitys(AlunoInDto aluno){
        if(aluno != null){
        this.username = aluno.getUsername();
        this.pass = aluno.getPass();
        this.email = aluno.getEmail();
        this.photo = aluno.getPhoto();
        }
    }

}