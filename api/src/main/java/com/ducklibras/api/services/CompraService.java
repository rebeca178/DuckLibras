package com.ducklibras.api.services;

import java.util.List;
import com.ducklibras.api.models.repo.lojaRepo;
import com.ducklibras.api.models.entitys.lojaEntitys;
import com.ducklibras.api.models.repo.comprasRepo;
import com.ducklibras.api.models.entitys.CompraEntitys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompraService {

    @Autowired
    private lojaRepo lojaRepo;

    @Autowired
    private comprasRepo comprasRepo;

    public List<lojaEntitys> listarTodos() {
        return lojaRepo.findAll();
    }

    public void comprar(Long lojaId, int quantidade) {
        lojaEntitys item = lojaRepo.findById(lojaId)
            .orElseThrow(() -> new RuntimeException("Item não encontrado"));

        CompraEntitys compra = new CompraEntitys();
        compra.setId(lojaId); 
        compra.setQuantidade(quantidade);
        
        double precoTotal = item.getPreco() * quantidade;
        compra.setPrecoTotal(precoTotal);
        
        comprasRepo.save(compra);
    }

    public void calcularPreco(lojaEntitys loja, int quantidade) {
        double preco = loja.getPreco() * quantidade;
        System.out.println("Preço total: " + preco);
    }
}


