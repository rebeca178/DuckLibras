package com.example.mobileducklibras.Anotacoes.presetation;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.snackbar.Snackbar;

public class AnotacoesActivity extends AppCompatActivity {

    private ActivityAnotacoesBinding binding;
    private AnotacoesViewModel viewModel;
    private InputMethodManager inputMethodManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        binding = ActivityAnotacoesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        
        viewModel = new ViewModelProvider(this).get(AnotacoesViewModel.class);
        inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        
        configurarToolbar();
        configurarObservadores();
        configurarListeners();
    }

    private void configurarToolbar() {
        setSupportActionBar(binding.toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Minhas Anotações");
        }
        
        binding.toolbar.setNavigationOnClickListener(v -> finish());
    }

    private void configurarObservadores() {
        viewModel.getNotas().observe(this, notas -> {
            if (notas == null || notas.isEmpty()) {
                binding.savedNotesTextView.setText("Nenhuma anotação salva ainda");
                binding.clearButton.setEnabled(false);
            } else {
                binding.savedNotesTextView.setText(notas);
                binding.clearButton.setEnabled(true);
            }
        });
        
        viewModel.getEstadoSalvamento().observe(this, sucesso -> {
            if (sucesso != null) {
                mostrarFeedback(sucesso ? 
                    "Anotação salva com sucesso" : 
                    "Erro ao salvar anotação");
            }
        });
    }

    private void configurarListeners() {
        binding.noteEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                binding.saveButton.setEnabled(s.length() > 0);
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        // Botão Salvar
        binding.saveButton.setOnClickListener(v -> {
            String texto = binding.noteEditText.getText().toString().trim();
            viewModel.adicionarNota(texto);
            esconderTeclado();
            binding.noteEditText.setText("");
        });

        // Botão Limpar
        binding.clearButton.setOnClickListener(v -> {
            viewModel.limparNotas();
            esconderTeclado();
        });
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
