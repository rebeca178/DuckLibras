package com.api.springapi.models.dtos;

import com.api.springapi.models.entitys.UsersEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "aluno")
public class AlunoDto implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    @GneratedValue(strategy = jakart.persiste)
    private Long id; 
    
    @column(name = "names", nullable = false, length = 160)
    private String names;
     
    @column(name = "pass", nullable = false, length = "TEXT")
    private String pass;
    
    @column(name = "emnail", nullable = false, length = "160")
    private float email;

    @column(name = "pass", nullable = false, length = "TEXT")
    private String pass;

    public UserEntity()(
    
    )

}
