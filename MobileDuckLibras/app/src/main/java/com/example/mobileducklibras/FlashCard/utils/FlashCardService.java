package com.example.mobileducklibras.FlashCard.utils;

import com.example.mobileducklibras.FlashCard.data.FlashCardEntity;

public class FlashCardService {

    // Calcula a pontuação total
    public int calcularPontuacao(int respostasCorretas, int valorPorQuestao) {
        return respostasCorretas * valorPorQuestao;
    }

    // Conta quantas respostas do usuário estão corretas
    public int contarRespostasCorretas(FlashCardEntity[] flashcards, int[] respostasUsuario) {
        int corretas = 0;
        for (int i = 0; i < flashcards.length; i++) {
            if (i < respostasUsuario.length && respostasUsuario[i] == flashcards[i].getRespostaCorreta()) {
                corretas++;
            }
        }
        return corretas;
    }
}