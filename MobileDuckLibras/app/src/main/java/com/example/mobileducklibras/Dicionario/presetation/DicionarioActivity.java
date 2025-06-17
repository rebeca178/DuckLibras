package com.example.mobileducklibras.Dicionario.presetation;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem; // Se estiver usando a toolbar com menu
import android.widget.EditText; // Se estiver usando a barra de pesquisa
import android.widget.ImageView; // Necessário para os botões da barra de navegação
import android.widget.Toast; // Para as mensagens Toast

import androidx.annotation.NonNull; // Se estiver usando @NonNull
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobileducklibras.Dicionario.data.DicionarioLibrasEntity;
import com.example.mobileducklibras.FlashCard.FlashcardActivity;
import com.example.mobileducklibras.Home.Home;
import com.example.mobileducklibras.R;

import java.util.ArrayList;
import java.util.List;

public class DicionarioActivity extends AppCompatActivity {

    private DicionarioViewModel dicionarioViewModel;
    private DicionarioAdapter dicionarioAdapter;
    private RecyclerView recyclerView;
    private EditText searchEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dicionario);

        // Inicializa o ViewModel
        dicionarioViewModel = new ViewModelProvider(this).get(DicionarioViewModel.class);

        // Inicializa o RecyclerView e o Adapter
        recyclerView = findViewById(R.id.recyclerViewDicionario);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        dicionarioAdapter = new DicionarioAdapter(new ArrayList<>());
        recyclerView.setAdapter(dicionarioAdapter);

        // Configura a barra de pesquisa
        searchEditText = findViewById(R.id.searchEditText);
        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Não é necessário implementar
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Filtra a lista enquanto o usuário digita
                dicionarioViewModel.filterDicionario(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Não é necessário implementar
            }
        });

        // Observa as alterações na lista de palavras do dicionário
        dicionarioViewModel.getDicionarioList().observe(this, dicionarioList -> {
            dicionarioAdapter.updateList(dicionarioList);
        });

        // Observa erros (opcional)
        dicionarioViewModel.getError().observe(this, errorMessage -> {
            if (errorMessage != null) {
                Toast.makeText(DicionarioActivity.this, "Erro: " + errorMessage, Toast.LENGTH_LONG).show();
            }
        });

        // Carrega os dados do dicionário
        dicionarioViewModel.loadDicionario();

        // Configuração da Toolbar
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Dicionário LIBRAS");

        // Configuração dos botões da barra de navegação inferior
        ImageView homeButton = findViewById(R.id.home_btn);
        ImageView flashcardButton = findViewById(R.id.flashcard_btn);
        ImageView dicionarioButton = findViewById(R.id.dicionario_btn);
        ImageView traducaoButton = findViewById(R.id.traducao_btn);
        ImageView pontuacaoButton = findViewById(R.id.pontuacao_btn);

        homeButton.setOnClickListener(v -> {
            startActivity(new Intent(DicionarioActivity.this, Home.class));
            finish();
        });

        flashcardButton.setOnClickListener(v -> {
            startActivity(new Intent(DicionarioActivity.this, FlashcardActivity.class));
            finish();
        });

        dicionarioButton.setOnClickListener(v -> {
            Toast.makeText(DicionarioActivity.this, "Você já está no Dicionário!", Toast.LENGTH_SHORT).show();
        });

        traducaoButton.setOnClickListener(v -> {
            // Implementar a navegação para a TraducaoActivity quando ela estiver pronta
            // startActivity(new Intent(DicionarioActivity.this, TraducaoActivity.class));
            Toast.makeText(DicionarioActivity.this, "Funcionalidade de Tradução em breve!", Toast.LENGTH_SHORT).show();
        });

        pontuacaoButton.setOnClickListener(v -> {
            // Implementar a navegação para a PontuacaoActivity quando ela estiver pronta
            // startActivity(new Intent(DicionarioActivity.this, PontuacaoActivity.class));
            Toast.makeText(DicionarioActivity.this, "Funcionalidade de Pontuação em breve!", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}