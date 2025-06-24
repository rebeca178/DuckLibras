package com.example.mobileducklibras.Home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mobileducklibras.Anotacao.AnotacaoActivity;
import com.example.mobileducklibras.Dicionario.presetation.DicionarioActivity;
import com.example.mobileducklibras.FlashCard.presetation.FlashcardActivity;
import com.example.mobileducklibras.R;
import com.example.mobileducklibras.Traducao.TraducaoActivity;
import com.example.mobileducklibras.AulasActivity;
import com.example.mobileducklibras.user.presetation.ProfileActivity;

public class Home extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
    }

    public void flashcard_btn(View view) {
        Intent intent = new Intent(this, FlashcardActivity.class);
        startActivity(intent);
    }

    public void anotacao_btn(View view) {
        Intent intent = new Intent(this, AnotacaoActivity.class);
        startActivity(intent);
    }

    public void traducao_btn(View view) {
        Intent intent = new Intent(this, TraducaoActivity.class);
        startActivity(intent);
    }

    public void dicionario_btn(View view) {
        Intent intent = new Intent(this, DicionarioActivity.class);
        startActivity(intent);
    }

    public void user_btn(View view) {
        Intent intent = new Intent(this, com.example.mobileducklibras.user.presetation.ProfileActivity.class);
        startActivity(intent);
    }

    public void bsativo_btn(View view) {
        Intent intent = new Intent(this, AulasActivity.class);
        startActivity(intent);
    }



    // Se tiver outros botões, adicione métodos aqui também
}