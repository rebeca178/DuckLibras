package com.ducklibras.api.models.entitys;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Column;

@Getter
@Setter

@Entity
@Table(name = "aulas")
public class AulasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "explicacao", nullable = false, length = 255)
    private String explicacao;

    @ManyToOne
    @JoinColumn(name = "Pid")
    private PontuacaoEntity pontuacao;

    @ManyToOne
    @JoinColumn(name = "DICIOid")
    private DicionarioLibrasEntity dicionarioLibras;

    public AulasEntity() {
    }

    public AulasEntity(String explicacao, PontuacaoEntity pontuacao, DicionarioLibrasEntity dicionarioLibras) {
        this.explicacao = explicacao;
        this.pontuacao = pontuacao;
        this.dicionarioLibras = dicionarioLibras;
    }

    @ManyToMany
    @JoinTable(
        name = "au_al",
        joinColumns = @JoinColumn(name = "id_aula"),
        inverseJoinColumns = @JoinColumn(name = "id_aluno")
    )
    private AlunoEntitys asAulas;
}
