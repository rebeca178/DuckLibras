package com.ducklibras.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;



@Service
public class CompraService {

    @Autowired
    private lojaRepo lojaRepo;

    @Autowired
    private compraRepo compraRepo;

    public List<LojaEntity> listarTodos() {
        return lojaRepo.findAll();
        
    }

    public void comprar(Long lojaId, int quantidade) {

        CompraEntity compra = new CompraEntity();
        compra.setLojaId(lojaId);
        compra.setQuantidade(quantidade);
       
    }

    public void preco(LojaEntity loja, int quantidade) {
        double preco = loja.getPreco() * quantidade;
        System.out.println("Preço total: " + preco);

    }

}


