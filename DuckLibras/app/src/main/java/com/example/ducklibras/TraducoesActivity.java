package com.example.ducklibras;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class TraducoesActivity extends AppCompatActivity {

    private EditText translationEditText;
    private TextView translationResultTextView;
    private Button translateButton;
    private Button playButton;
    private TraducoesViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translations);
        
        viewModel = new ViewModelProvider(this).get(TraducoesViewModel.class);
        inicializarViews();
        configurarObservers();
        configurarListeners();
    }

    private void inicializarViews() {
        translationEditText = findViewById(R.id.translationEditText);
        translationResultTextView = findViewById(R.id.translationResultTextView);
        translateButton = findViewById(R.id.translateButton);
        playButton = findViewById(R.id.playTranslationButton);
        
        playButton.setEnabled(false);
    }

    private void configurarObservers() {
        viewModel.getResultadoTraducao().observe(this, resultado -> {
            translationResultTextView.setText(resultado);
            playButton.setEnabled(!resultado.isEmpty());
        });
    }

    private void configurarListeners() {
        translateButton.setOnClickListener(v -> {
            String texto = translationEditText.getText().toString().trim();
            if (texto.isEmpty()) {
                Utils.mostrarToast(this, "Digite um texto para traduzir");
                return;
            }
            viewModel.traduzirTexto(texto);
        });

        playButton.setOnClickListener(v -> {
            if (viewModel.getResultadoTraducao().getValue() != null) {
                viewModel.reproduzirTraducao();
                Utils.mostrarToast(this, "Reproduzindo tradução...");
            }
        });
    }
}
