package com.example.mobileducklibras.FlashCard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mobileducklibras.Anotacao.AnotacaoActivity;
import com.example.mobileducklibras.AulasActivity;
import com.example.mobileducklibras.R;
import com.example.mobileducklibras.Traducao.TraducaoActivity;

public class FlashcardActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flashcard);
    }

    public void home_btn(View view) {
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

    public void bsativo_btn(View view) {
        Intent intent = new Intent(this, AulasActivity.class);
        startActivity(intent);
    }
}
