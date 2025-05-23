package com.example.ducklibras;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import com.example.ducklibras.databinding.ActivityTraducoesBinding;
import com.google.android.material.snackbar.Snackbar;

public class TraducoesActivity extends AppCompatActivity {

    private ActivityTraducoesBinding binding;
    private TraducoesViewModel viewModel;
    private InputMethodManager inputMethodManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        binding = ActivityTraducoesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        
        viewModel = new ViewModelProvider(this).get(TraducoesViewModel.class);
        inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        
        configurarToolbar();
        configurarObservadores();
        configurarListeners();
        configurarPalavrasRapidas();
    }

    private void configurarToolbar() {
        setSupportActionBar(binding.toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Tradutor LIBRAS");
        }
        
        binding.toolbar.setNavigationOnClickListener(v -> finish());
    }

    private void configurarObservadores() {
        viewModel.getResultadoTraducao().observe(this, resultado -> {
            if (resultado == null || resultado.isEmpty()) {
                binding.translationResultTextView.setText("Tradução aparecerá aqui");
                binding.playButton.setEnabled(false);
            } else {
                binding.translationResultTextView.setText(resultado);
                binding.playButton.setEnabled(true);
            }
        });
        
        viewModel.getEstadoTraducao().observe(this, estado -> {
            if (estado != null) {
                String mensagem = estado ? 
                    "Tradução realizada com sucesso" : 
                    "Erro ao processar tradução";
                mostrarFeedback(mensagem);
            }
        });
        
        viewModel.getEstadoReproducao().observe(this, estado -> {
            if (estado != null) {
                String mensagem = estado ? 
                    "Reproduzindo sinalização..." : 
                    "Erro ao reproduzir sinalização";
                mostrarFeedback(mensagem);
            }
        });
    }

    private void configurarListeners() {
        // Botão Traduzir
        binding.translateButton.setOnClickListener(v -> {
            String texto = binding.translationEditText.getText().toString().trim();
            if (texto.isEmpty()) {
                binding.translationEditText.setError("Digite um texto para traduzir");
                return;
            }
            viewModel.traduzirTexto(texto);
            esconderTeclado();
        });

        binding.playButton.setOnClickListener(v -> {
            viewModel.reproduzirTraducao();
        });
    }

    private void configurarPalavrasRapidas() {
        int[] buttonIds = {
            R.id.btn_palavra1, R.id.btn_palavra2, R.id.btn_palavra3,
            R.id.btn_palavra4, R.id.btn_palavra5
        };
        
        String[] palavras = {"Olá", "Obrigado", "Bom dia", "Como vai?", "Ajuda"};
        
        for (int i = 0; i < buttonIds.length && i < palavras.length; i++) {
            int finalI = i;
            binding.getRoot().findViewById(buttonIds[i]).setOnClickListener(v -> {
                binding.translationEditText.setText(palavras[finalI]);
                binding.translateButton.performClick(); // Aciona a tradução automaticamente
            });
        }
    }

    private void esconderTeclado() {
        if (getCurrentFocus() != null) {
            inputMethodManager.hideSoftInputFromWindow(
                getCurrentFocus().getWindowToken(), 0);
        }
    }

    private void mostrarFeedback(String mensagem) {
        Snackbar.make(binding.getRoot(), mensagem, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}
