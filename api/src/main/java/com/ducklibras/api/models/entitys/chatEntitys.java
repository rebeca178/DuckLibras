package com.ducklibras.api.models.entitys;

import java.io.Serializable;
import java.util.List;

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

    @Column(name = "chat", nullable = false, columnDefinition = "TEXT")
    private String chat;

    @OneToOne
    @JoinColumn(name = "remetente" , nullable = false)
    private AlunoEntitys remetente;

    @OneToOne
    @JoinColumn(name = "destinatario" , nullable = false)
    private AlunoEntitys destinatario;

    public chatEntitys() {
    }

    public static List<chatEntitys> buscarConversas(String remetente2, String destinatario2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarConversas'");
    }
    
}
