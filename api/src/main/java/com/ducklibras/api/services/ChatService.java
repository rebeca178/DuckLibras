package com.ducklibras.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class ChatService {

    @Autowired
    private chatRepo chatRepo;

    public chatEntitys enviarMensagem(chatEntitys mensagem) {
        return chatRepo.save(chat);
    }

    public List<chatEntitys> buscarConversas(String remetente, String destinatario) {
        return chatRepo.findByRemetenteAndDestinatario(remetente, destinatario);
    }
    
}
