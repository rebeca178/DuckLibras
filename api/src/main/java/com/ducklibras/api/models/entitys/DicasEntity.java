package com.ducklibras.api.models.entitys;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

import jacarta.persistence.Entity;
import jacarta.persistence.Table;


@Gettter
@Setter

@Entity
@Table(name = "Dicas")
public class DicasEntity implements Serializable{

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
    private ComprasEntity CId;

    @OneToOne
    @JoinColumn(name = "FId", nullable = false)
    private FlashCardEntity FId;
   
    
    public DicasEntityEntity(DicasDtoDto user){
        this.ajuda = user.getajuda();
 
    }


}


public class DicasEntitys {


}
