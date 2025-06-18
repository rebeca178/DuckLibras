package com.example.mobileducklibras.Home;

import android.content.Intent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mobileducklibras.FlashCard.FlashcardActivity;

public class Home extends AppCompatActivity {

    public void flashcard_btn(View view) {
        Intent intent = new Intent(this, FlashcardActivity.class);
        startActivity(intent);
    }

    //teste
}
