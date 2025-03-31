package com.ducklibras.api.models.entitys;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

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

    @ManyToOne
    @JoinColumn(name = "tradId", nullable = false)
    private TraducaoEntity tradId;

    @ManyToMany
    @JoinTable(
        name = "au_al",
        joinColumns = @JoinColumn(name = "id_aula"),
        inverseJoinColumns = @JoinColumn(name = "id_aluno")
    )
    private Set<AulasEntity> asAluno;
    
    @OneToOne
    @JoinColumn(name = "BSid")
    private BsEntitys BSid;

    @OneToOne
    @JoinColumn(name = "pontID")
    private PontuacaoEntity pontId;

    @ManyToOne
    @JoinColumn(name = "Id_al",nullable = false)
    private CompraEntitys compra;

    @OneToMany
    @JoinColumn(name = "Id_au" , nullable = false)
    private AulasEntity aulas;



}