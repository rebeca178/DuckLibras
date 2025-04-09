package com.ducklibras.api.models.entitys;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class HistoricoAssistido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "aluno_id", nullable = false)
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "aula_id", nullable = false)
    private Aula aula;

    @Column(name = "data_assistencia", nullable = false)
    private LocalDateTime dataAssistencia;

    // Construtor padrão (necessário para o JPA)
    public HistoricoAssistido() {
    }

    // Construtor completo
    public HistoricoAssistido(Aluno aluno, Aula aula, LocalDateTime dataAssistencia) {
        this.aluno = aluno;
        this.aula = aula;
        this.dataAssistencia = dataAssistencia;
    }

    // Getters e Setters gerados automaticamente pelo Lombok ou manualmente (se necessário)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    public LocalDateTime getDataAssistencia() {
        return dataAssistencia;
    }

    public void setDataAssistencia(LocalDateTime dataAssistencia) {
        this.dataAssistencia = dataAssistencia;
    }
}

    

