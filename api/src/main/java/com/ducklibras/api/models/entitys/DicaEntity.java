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
import jakarta.persistence.ManyToOne;
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
    
    @ManyToOne
    @JoinColumn(name = "dicioId", nullable = false)
    private DicionarioLibrasEntity dicioId;

    @OneToOne
    @JoinColumn(name = "CId", nullable = false)
    private CompraEntitys CId;

    @OneToOne
    @JoinColumn(name = "FId", nullable = false)
    private FlashCardsEntity FId;
   
    
    public DicaEntity(DicasDto user){
        this.ajuda = user.getAjuda();
 
    }


    public Long getId() {
        throw new UnsupportedOperationException("Unimplemented method 'getId'");
    }


    public String getAjuda() {
        throw new UnsupportedOperationException("Unimplemented method 'getAjuda'");
    }


}
