package com.ducklibras.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ducklibras.api.models.repo.chatRepo;
import com.ducklibras.api.models.entitys.chatEntitys;

@Service
public class ChatService {

    @Autowired
    private chatRepo chatRepo;

    public chatEntitys enviarMensagem(chatEntitys mensagem) {
        return chatRepo.save(mensagem);
    }
}