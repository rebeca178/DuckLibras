package com.api.ducklibras.models.dtos;

import com.api.ducklibras.models.entitys.UsersEntity;

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
public class AlunoDto implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id; 
    
    @column(name = "username", nullable = false, length = 255)
    private String username;
     
    @column(name = "pass", nullable = false, length = "TEXT")
    private String pass;
    
    @column(name = "email", nullable = false, length = "160")
    private String email;

    @column(name = "photo", nullable = false, length = "160")
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
    
    @OneToMany
    @JoinColumn(name = "BSid", nullable = false)
    private BSEntity BSid;

    @OneToOne
    @JoinColumn(name = "pontID", nullable = false)
    private PontacaoEntity TradId;

    public UserEntity()(
    
    )

}
