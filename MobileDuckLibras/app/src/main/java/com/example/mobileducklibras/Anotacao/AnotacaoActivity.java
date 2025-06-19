package com.example.mobileducklibras.Anotacao;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mobileducklibras.R;

public class AnotacaoActivity extends AppCompatActivity {

    private EditText campoAnotacao;
    private SharedPreferences sharedPreferences;
    private static final String PREF_NAME = "AnotacaoPrefs";
    private static final String KEY_ANOTACAO = "minha_anotacao";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anotacao);

        campoAnotacao = findViewById(R.id.campoAnotacao);
        Button salvarBtn = findViewById(R.id.salvarAnotacao);

        sharedPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);

        String anotacaoSalva = sharedPreferences.getString(KEY_ANOTACAO, "");
        campoAnotacao.setText(anotacaoSalva);

        salvarBtn.setOnClickListener(view -> {
            String texto = campoAnotacao.getText().toString();

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(KEY_ANOTACAO, texto);
            editor.apply();

            Toast.makeText(AnotacaoActivity.this, "Anotação salva com sucesso!", Toast.LENGTH_SHORT).show();
        });

        configurarBotoesMenu();
    }

    private void configurarBotoesMenu() {
        findViewById(R.id.home_btn).setOnClickListener(v -> {
            Toast.makeText(this, "Home clicado", Toast.LENGTH_SHORT).show();
            // startActivity(new Intent(this, HomeActivity.class));
        });

        findViewById(R.id.flashcard).setOnClickListener(v -> {
            Toast.makeText(this, "Flashcard clicado", Toast.LENGTH_SHORT).show();
            // startActivity(new Intent(this, FlashcardActivity.class));
        });

        findViewById(R.id.anotacao).setOnClickListener(v -> {
            Toast.makeText(this, "Você já está nas anotações", Toast.LENGTH_SHORT).show();
        });

        findViewById(R.id.dicionario).setOnClickListener(v -> {
            Toast.makeText(this, "Dicionário clicado", Toast.LENGTH_SHORT).show();
            // startActivity(new Intent(this, DicionarioActivity.class));
        });

        findViewById(R.id.traducao).setOnClickListener(v -> {
            Toast.makeText(this, "Tradução clicada", Toast.LENGTH_SHORT).show();
            // startActivity(new Intent(this, TraducaoActivity.class));
        });

        findViewById(R.id.user).setOnClickListener(v -> {
            Toast.makeText(this, "Perfil clicado", Toast.LENGTH_SHORT).show();
            // startActivity(new Intent(this, PerfilActivity.class));
        });
    }
}