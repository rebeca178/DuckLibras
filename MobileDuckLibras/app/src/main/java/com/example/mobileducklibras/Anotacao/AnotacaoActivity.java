package com.example.mobileducklibras.Anotacao;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mobileducklibras.AulasActivity;
import com.example.mobileducklibras.FlashCard.presetation.FlashcardActivity;
import com.example.mobileducklibras.R;
import com.example.mobileducklibras.Traducao.TraducaoActivity;
import com.example.mobileducklibras.Home.Home;

public class AnotacaoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anotacao); // Use o layout correto!
    }

    public void home_btn(View view) {
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
        finish();
    }

    public void flashcard_btn(View view) {
        Intent intent = new Intent(this, FlashcardActivity.class);
        startActivity(intent);
        finish();
    }

    public void anotacao_btn(View view) {
        // Opcional: pode mostrar um Toast dizendo que já está na tela de Anotação
        // Toast.makeText(this, "Você já está em Anotações!", Toast.LENGTH_SHORT).show();
    }

    public void traducao_btn(View view) {
        Intent intent = new Intent(this, TraducaoActivity.class);
        startActivity(intent);
        finish();
    }

    public void dicionario_btn(View view) {
        Intent intent = new Intent(this, AulasActivity.class);
        startActivity(intent);
        finish();
    }
}