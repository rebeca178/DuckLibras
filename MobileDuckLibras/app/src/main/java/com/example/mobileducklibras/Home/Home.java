package com.example.mobileducklibras.Home;

import android.content.Intent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mobileducklibras.Aulas.Aula1Activity;
import com.example.mobileducklibras.FlashCard.FlashcardActivity;
import com.example.mobileducklibras.Traducao.TraducaoActivity;
import com.example.mobileducklibras.anotacao.AnotacaoActivity;
import com.example.ducklibras.Dicionario.presetation.DicionarioActivity;
import com.example.ducklibras.user.presetation.ProfileActivity;

public class Home extends AppCompatActivity {

    public void flashcard_btn(View view) {
        Intent intent = new Intent(this, FlashcardActivity.class);
        startActivity(intent);
    }
    public void anotacao_btn(View view) {
      Intent intent = new Intent(this, AnotacaoActivity.class);
     startActivity(intent);
   }

    public void dicionario_btn(View view) {
     Intent intent = new Intent(this, DicionarioActivity.class);
     startActivity(intent);
    }

     public void traducao_btn(View view) {
    Intent intent = new Intent(this, TraducaoActivity.class);
    startActivity(intent);
    }

    public void user_btn(View view) {
    Intent intent = new Intent(this, ProfileActivity.class);
    startActivity(intent);
    }

    public void bsativo_btn(View view) {
         Intent intent = new Intent(this, Aula1Activity.class);
        startActivity(intent);
        }


}
