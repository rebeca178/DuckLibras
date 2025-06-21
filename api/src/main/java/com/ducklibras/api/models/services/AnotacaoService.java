package com.ducklibras.api.models.services;

import com.ducklibras.api.models.dtos.AnotacaoinDto;

import com.ducklibras.api.models.entitys.AnotacaoEntity;

import com.ducklibras.api.models.repo.AnotacaoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AnotacaoService {

    @Autowired
    private AnotacaoRepository anotacaoRepository;

    public AnotacaoEntity criarAnotacao(AnotacaoEntity anotacao) {
        return anotacaoRepository.save(anotacao);
    }

    public Optional<AnotacaoEntity> buscarPorId(Long id) {
        return anotacaoRepository.findById(id);
    }

    public void deletarAnotacao(Long id) {
        anotacaoRepository.deleteById(id);
    }

    public List<AnotacaoEntity> listarTodas() {
        return anotacaoRepository.findAll();
    }

    public String createAula(AnotacaoinDto aula) {
        String response;
        if(ValidateAula(aula.getConteudo())){
            anotacaoRepository.save(new AnotacaoEntity(aula));
            response = "Aula Cadastrado com Sucesso";
        }else{
            response = "ERROR: Esta Aula já esta cadastrada";
        }

        return response;
    }

     public boolean ValidateAula(String titulo){
        return anotacaoRepository.findByTitulo(titulo).isEmpty();
    }
}
