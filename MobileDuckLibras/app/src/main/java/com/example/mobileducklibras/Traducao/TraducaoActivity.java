package com.example.mobileducklibras.Traducao;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mobileducklibras.Anotacao.AnotacaoActivity;
import com.example.mobileducklibras.AulasActivity;
import com.example.mobileducklibras.Dicionario.presetation.DicionarioActivity;
import com.example.mobileducklibras.FlashCard.presetation.FlashcardActivity;
import com.example.mobileducklibras.Home.Home;
import com.example.mobileducklibras.R;

public class TraducaoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.traducao);

        // Seu código de inicialização da tela...
    }

    // Métodos de navegação para usar no android:onClick do XML

    public void home_btn(View view) {
        startActivity(new Intent(this, Home.class));
        finish();
    }

    public void flashcard_btn(View view) {
        startActivity(new Intent(this, FlashcardActivity.class));
        finish();
    }

    public void anotacao_btn(View view) {
        startActivity(new Intent(this, AnotacaoActivity.class));
        finish();
    }

    public void dicionario_btn(View view) {
        Intent intent = new Intent(this, DicionarioActivity.class);
        startActivity(intent);
    }

    public void traducao_btn(View view) {
        // Já está na tela de tradução
        // Opcional: mostrar um Toast
        // Toast.makeText(this, "Você já está na Tradução!", Toast.LENGTH_SHORT).show();
    }
}