package com.example.ducklibras;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class AnotacoesActivity extends AppCompatActivity {

    private EditText noteEditText;
    private TextView savedNotesTextView;
    private Button saveButton;
    private Button clearButton;
    private AnotacoesViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        
        viewModel = new ViewModelProvider(this).get(AnotacoesViewModel.class);
        inicializarViews();
        configurarObservers();
        configurarListeners();
    }

    private void inicializarViews() {
        noteEditText = findViewById(R.id.noteEditText);
        savedNotesTextView = findViewById(R.id.savedNotesTextView);
        saveButton = findViewById(R.id.saveNoteButton);
        clearButton = findViewById(R.id.clearNotesButton);

        saveButton.setEnabled(false);
    }

    private void configurarObservers() {
        viewModel.getNotas().observe(this, notas -> {
            savedNotesTextView.setText(notas);
            clearButton.setEnabled(!notas.isEmpty());
        });
    }

    private void configurarListeners() {
        noteEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                saveButton.setEnabled(s.length() > 0);
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        saveButton.setOnClickListener(v -> {
            String texto = noteEditText.getText().toString().trim();
            viewModel.adicionarNota(texto);
            noteEditText.setText("");
            Utils.mostrarToast(this, "Nota salva com sucesso");
        });

        clearButton.setOnClickListener(v -> {
            viewModel.limparNotas();
            Utils.mostrarToast(this, "Notas removidas");
        });
    }
}
