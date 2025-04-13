package com.ducklibras.api.models.entitys;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "traducoes")
public class TraducaoEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "idioma_origem", nullable = false, length = 100)
    private String idiomaOrigem;

    @Column(name = "idioma_destino", nullable = false, length = 100)
    private String idiomaDestino;

    @Column(name = "texto_original", nullable = false, columnDefinition = "TEXT")
    private String textoOriginal;

    @Column(name = "texto_traduzido", nullable = false, columnDefinition = "TEXT")
    private String textoTraduzido;

}
