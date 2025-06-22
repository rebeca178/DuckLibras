package com.example.mobileducklibras.FlashCard.data;

public class FlashCardEntity {
    private int imagemResId;
    private String[] alternativas;
    private int respostaCorreta;

    public FlashCardEntity(int imagemResId, String[] alternativas, int respostaCorreta) {
        this.imagemResId = imagemResId;
        this.alternativas = alternativas;
        this.respostaCorreta = respostaCorreta;
    }

    public int getImagemResId() { return imagemResId; }
    public String[] getAlternativas() { return alternativas; }
    public int getRespostaCorreta() { return respostaCorreta; }
}