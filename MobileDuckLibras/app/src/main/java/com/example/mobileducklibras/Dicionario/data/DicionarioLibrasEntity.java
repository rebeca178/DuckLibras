package com.example.mobileducklibras.Dicionario.data;

public class DicionarioLibrasEntity {
    private String palavra;
    private String traducao;
    private String descricao;
    private int imagemResId; // Novo campo para imagem

    public DicionarioLibrasEntity(String palavra, String traducao, String descricao, int imagemResId) {
        this.palavra = palavra;
        this.traducao = traducao;
        this.descricao = descricao;
        this.imagemResId = imagemResId;
    }

    public String getPalavra() { return palavra; }
    public String getTraducao() { return traducao; }
    public String getDescricao() { return descricao; }
    public int getImagemResId() { return imagemResId; }
}