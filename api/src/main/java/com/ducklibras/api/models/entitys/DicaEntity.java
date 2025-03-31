package com.ducklibras.api.models.entitys;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

import com.ducklibras.api.models.dtos.DicasDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Getter
@Setter

@Entity
@Table(name = "dicas")
public class DicaEntity implements Serializable{

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;


    @Column(name = "ajuda", nullable = false, columnDefinition = "TEXT")
    private String ajuda;
    
    @OneToOne
    @JoinColumn(name = "DicioId", nullable = false)
    private DicionarioLibrasEntity DicioIdId;

    @OneToOne
    @JoinColumn(name = "CId", nullable = false)
    private CompraEntitys CId;

    @OneToOne
    @JoinColumn(name = "FId", nullable = false)
    private FlashCardEntity FId;
   
    
    public DicaEntity(DicasDto user){
        this.ajuda = user.getAjuda();
 
    }


    public Long getId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getId'");
    }


    public String getAjuda() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAjuda'");
    }


}
