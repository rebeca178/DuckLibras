package com.example.mobileducklibras.Traducao;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mobileducklibras.R;
import com.google.android.ads.mediationtestsuite.activities.HomeActivity;

public class TraducaoActivity extends AppCompatActivity {

    private TextView pontosTextView;
    private TextView nivelTextView;
    private ImageView iconeLibras;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.traducao);

        // Referências UI
        pontosTextView = findViewById(R.id.pontos);
        nivelTextView = findViewById(R.id.nivel);
        iconeLibras = findViewById(R.id.icone_libras);

        // Definindo valores iniciais (exemplo)
        pontosTextView.setText("Pontos: 120");
        nivelTextView.setText("Nível: 3");

        // Click no ícone libras só para exemplo
        iconeLibras.setOnClickListener(v -> {
            Toast.makeText(this, "Ícone Libras clicado!", Toast.LENGTH_SHORT).show();
        });

        // Configura os botões do menu inferior
        findViewById(R.id.home_btn).setOnClickListener(v -> irParaHome());
        findViewById(R.id.traducao).setOnClickListener(v -> {
            // Já está aqui, pode mostrar feedback ou ignorar
            Toast.makeText(this, "Você já está na Tradução!", Toast.LENGTH_SHORT).show();
        });

        // Menu superior - usuário
        findViewById(R.id.user).setOnClickListener(v -> {
            Toast.makeText(this, "Perfil do usuário clicado!", Toast.LENGTH_SHORT).show();
            // Aqui pode abrir a activity de perfil futuramente
        });
    }

    private void irParaHome() {
        // Intent para HomeActivity (troque pelo nome real)
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
        finish();
    }
}