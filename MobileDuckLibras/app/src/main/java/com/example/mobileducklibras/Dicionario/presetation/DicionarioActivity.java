package com.example.mobileducklibras.Dicionario.presetation;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobileducklibras.Anotacao.AnotacaoActivity;
import com.example.mobileducklibras.FlashCard.presetation.FlashcardActivity;
import com.example.mobileducklibras.Home.Home;
import com.example.mobileducklibras.R;
import com.example.mobileducklibras.Traducao.TraducaoActivity;
import com.example.mobileducklibras.AulasActivity;

import java.util.ArrayList;

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
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                dicionarioViewModel.filterDicionario(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {}
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
    }

    // Métodos de navegação para usar no android:onClick do XML

    public void home_btn(View view) {
        startActivity(new Intent(this, Home.class));
        finish();
    }

    public void flashcard_btn(View view) {
        startActivity(new Intent(this, FlashcardActivity.class));
        finish();
    }

    public void anotacao_btn(View view) {
        startActivity(new Intent(this, AnotacaoActivity.class));
        finish();
    }

    public void traducao_btn(View view) {
        startActivity(new Intent(this, TraducaoActivity.class));
        finish();
    }

    public void dicionario_btn(View view) {
        Toast.makeText(this, "Você já está no Dicionário!", Toast.LENGTH_SHORT).show();
    }

    public void dicionarioAulas_btn(View view) {
        startActivity(new Intent(this, AulasActivity.class));
        finish();
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