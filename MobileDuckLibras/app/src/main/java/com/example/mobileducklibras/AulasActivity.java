package com.example.mobileducklibras;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mobileducklibras.R;

public class AulasActivity extends AppCompatActivity {

    private FrameLayout containerLayout;
    private int currentIndex = 0;

    // Lista dos layouts XML das aulas 1 com vogais
    private final int[] layouts = {
            R.layout.aula_1_a,
            R.layout.aula_1_e,
            R.layout.aula_1_i,
            R.layout.aula_1_o,
            R.layout.aula_1_u
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aulas);

        containerLayout = findViewById(R.id.containerLayout);
        Button btnProximo = findViewById(R.id.btnProximo);
        Button btnAnterior = findViewById(R.id.btnAnterior);

        // Carrega o primeiro XML
        mostrarLayoutAtual();

        btnProximo.setOnClickListener(v -> {
            if (currentIndex < layouts.length - 1) {
                currentIndex++;
                mostrarLayoutAtual();
            }
        });

        btnAnterior.setOnClickListener(v -> {
            if (currentIndex > 0) {
                currentIndex--;
                mostrarLayoutAtual();
            }
        });
    }

    private void mostrarLayoutAtual() {
        containerLayout.removeAllViews();
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(layouts[currentIndex], containerLayout, false);
        containerLayout.addView(view);
    }
}
