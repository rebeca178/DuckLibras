package com.example.mobileducklibras.Anotacao;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mobileducklibras.AulasActivity;
import com.example.mobileducklibras.FlashCard.FlashcardActivity;
import com.example.mobileducklibras.R;
import com.example.mobileducklibras.Traducao.TraducaoActivity;

public class AnotacaoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
    }

    public void flashcard_btn(View view) {
        Intent intent = new Intent(this, FlashcardActivity.class);
        startActivity(intent);
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

    // Se tiver outros botões, adicione métodos aqui também
}