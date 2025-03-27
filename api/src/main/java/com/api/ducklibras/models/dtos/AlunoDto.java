package com.api.ducklibras.models.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "aluno")
public class AlunoDto implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id; 
    
    @Column(name = "username", nullable = false, length = 255)
    private String username;
     
    @Column(name = "pass", nullable = false, length = "TEXT")
    private String pass;
    
    @Column(name = "email", nullable = false, length = 160)
    private String email;

    @Column(name = "photo", nullable = false, length = 160)
    private String photo;

    @ManyToOne
    @JoinColumn(name = "TradId", nullable = false)
    private TraducaoEntity TradId;

    @ManyToMany
    @JoinTable(
        name = "au_al",
        joinColumns = @JoinColumn(name = "id_aula"),
        inverseJoinColumns = @JoinColumn(name = "id_aluno")
    )
    
    @OneToOne
    @JoinColumn(name = "BSid")
    private BSEntity BSid;

    @OneToOne
    @JoinColumn(name = "pontID", nullable = false)
    private PontacaoEntity TradId;

    public AlunoDto ()(
    
    )

}
