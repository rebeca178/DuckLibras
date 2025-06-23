package com.example.myapplication;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private TextView tvPalavra, tvTentativas, tvResultado;
    private EditText etLetra;
    private Button btnTentar;

    private String palavraSecreta;
    private char[] palavraAtual;
    private int tentativasRestantes = 6;
    private Set<Character> letrasTentadas = new HashSet<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvPalavra = findViewById(R.id.tvPalavra);
        tvTentativas = findViewById(R.id.tvTentativas);
        tvResultado = findViewById(R.id.tvResultado);
        etLetra = findViewById(R.id.etLetra);
        btnTentar = findViewById(R.id.btnTentar);

        solicitarPalavraSecreta();

        btnTentar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String entrada = etLetra.getText().toString().toUpperCase();
                if (entrada.isEmpty() || !Character.isLetter(entrada.charAt(0))) {
                    Toast.makeText(MainActivity.this, "Digite uma letra válida", Toast.LENGTH_SHORT).show();
                    return;
                }

                char letra = entrada.charAt(0);

                if (letrasTentadas.contains(letra)) {
                    Toast.makeText(MainActivity.this, "Letra já tentada", Toast.LENGTH_SHORT).show();
                    return;
                }

                letrasTentadas.add(letra);

                if (palavraSecreta.indexOf(letra) >= 0) {
                    for (int i = 0; i < palavraSecreta.length(); i++) {
                        if (palavraSecreta.charAt(i) == letra) {
                            palavraAtual[i] = letra;
                        }
                    }
                } else {
                    tentativasRestantes--;
                }

                atualizarInterface();
                verificarFimDeJogo();
                etLetra.setText("");
            }
        });
    }

    private void solicitarPalavraSecreta() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Escolha a palavra secreta");

        final EditText input = new EditText(this);
        input.setInputType(android.text.InputType.TYPE_CLASS_TEXT);
        builder.setView(input);

        builder.setCancelable(false);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                palavraSecreta = input.getText().toString().toUpperCase().trim();

                if (palavraSecreta.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Palavra inválida, tente novamente.", Toast.LENGTH_SHORT).show();
                    solicitarPalavraSecreta();  // Reabre se vazio
                } else {
                    inicializarJogo();
                }
            }
        });

        builder.show();
    }

    private void inicializarJogo() {
        palavraAtual = new char[palavraSecreta.length()];
        for (int i = 0; i < palavraAtual.length; i++) {
            palavraAtual[i] = '_';
        }
        tentativasRestantes = 6;
        letrasTentadas.clear();
        tvResultado.setText("");
        atualizarInterface();
    }

    private void atualizarInterface() {
        StringBuilder exibicao = new StringBuilder();
        for (char c : palavraAtual) {
            exibicao.append(c).append(" ");
        }
        tvPalavra.setText(exibicao.toString().trim());
        tvTentativas.setText("Tentativas restantes: " + tentativasRestantes);
    }

    private void verificarFimDeJogo() {
        if (String.valueOf(palavraAtual).equals(palavraSecreta)) {
            tvResultado.setText("Você venceu! 🎉");
            btnTentar.setEnabled(false);
        } else if (tentativasRestantes == 0) {
            tvResultado.setText("Você perdeu! Palavra era: " + palavraSecreta);
            btnTentar.setEnabled(false);
        }
    }
}
