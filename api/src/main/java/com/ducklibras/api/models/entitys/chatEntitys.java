package com.ducklibras.api.models.entitys;

import java.io.Serializable;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "chat")
public class chatEntitys implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    private Long id;

    
    @Column(name = "mensagem", nullable = false, columnDefinition = "TEXT")
    private String mensagem;

    @OneToOne
    @JoinColumn(name = "remetente" , nullable = false)
    private usuarioEntitys remetente;

    @OneToOne
    @JoinColumn(name = "destinatario" , nullable = false)
    private usuarioEntitys destinatario;

    public chatEntitys() {
    }
    
}
