package com.ducklibras.api.models.entitys;

import jakarta.persistence.*;

@Entity
@Table(name = "traducao")
public class Traducao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String textoOriginal;
    
    @Column(nullable = false)
    private String textoTraduzido;
    
    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTextoOriginal() {
        return textoOriginal;
    }

    public void setTextoOriginal(String textoOriginal) {
        this.textoOriginal = textoOriginal;
    }

    public String getTextoTraduzido() {
        return textoTraduzido;
    }

    public void setTextoTraduzido(String textoTraduzido) {
        this.textoTraduzido = textoTraduzido;
    }
}
