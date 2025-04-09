package com.ducklibras.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ducklibras.api.services.ChatService;

@RestController
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @PostMapping("/enviar")
    public ChatEntitys enviar(@RequestBody ChatEntitys mensagem) {
        return chatService.enviarMensagem(mensagem);
    }

    @GetMapping("/conversa")
    public List<ChatEntitys> conversa(
            @RequestParam String remetente,
            @RequestParam String destinatario){ 
            return ChatService.buscarConversas(remetente, destinatario);
       
}
    
