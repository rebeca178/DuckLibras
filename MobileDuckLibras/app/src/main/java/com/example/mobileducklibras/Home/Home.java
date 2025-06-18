package com.example.mobileducklibras.Home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mobileducklibras.FlashCard.FlashcardActivity;
import com.example.mobileducklibras.R;

public class Home extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home); // ou R.layout.activity_home, conforme o nome do seu XML
    }
}

