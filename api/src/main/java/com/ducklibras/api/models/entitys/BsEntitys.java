package com.ducklibras.api.models.entitys;

import java.io.Serializable;

import com.ducklibras.api.models.entitys.BsEntitys;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "BS")
public class BsEntitys implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Column(name = "status", nullable = false, columnDefinition = "boolean")
    private boolean status;

    @OneToOne
    @JoinColumn(name = "auID")
    private AulasEntity aulasId;

    @ManyToOne
    @JoinColumn(name = "flashId")
    private FlashcardEntity flashId;

    @OneToOne
    @JoinColumn(name = "ponId")
    private PontuacaoEntity ponID;

}
   