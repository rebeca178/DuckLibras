package com.ducklibras.api.services;

import java.util.List;
import com.ducklibras.api.models.entitys.lojaEntitys;
import com.ducklibras.api.models.repo.lojaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LojaService {

    @Autowired
    private lojaRepo lojaRepo;

    //listar todos os produtos
    public List<lojaEntitys> listarTodos() {
        return lojaRepo.findAll();
    }

    //salvar um novo produto
    public lojaEntitys salvar(lojaEntitys produto) {
        return lojaRepo.save(produto);
    }

    // deletar um produto pelo id
    public void excluir(Long id) {
        lojaRepo.deleteById(id);
    }

}
