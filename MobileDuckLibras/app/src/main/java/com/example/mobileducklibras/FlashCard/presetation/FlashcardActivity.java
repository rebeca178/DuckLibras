package com.example.mobileducklibras.FlashCard.presetation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mobileducklibras.Anotacao.AnotacaoActivity;
import com.example.mobileducklibras.AulasActivity;
import com.example.mobileducklibras.FlashCard.data.FlashCardEntity;
import com.example.mobileducklibras.FlashCard.utils.FlashCardService;
import com.example.mobileducklibras.R;
import com.example.mobileducklibras.Traducao.TraducaoActivity;
import com.example.mobileducklibras.Home.Home;

public class FlashcardActivity extends AppCompatActivity {

    private final FlashCardEntity[] flashCards = new FlashCardEntity[]{
            new FlashCardEntity(R.drawable.a, new String[]{"A", "E", "I", "O"}, 0),
            new FlashCardEntity(R.drawable.e, new String[]{"U", "E", "I", "A"}, 1),
            new FlashCardEntity(R.drawable.u, new String[]{"O", "E", "U", "I"}, 2)
    };

    private int indiceAtual = 0;
    private int[] respostasUsuario = new int[flashCards.length]; // -1 = não respondeu
    private ImageView imageView;
    private CheckBox[] checkBoxes;
    private Button proximoBtn;
    private Button finalizarBtn;
    private FlashCardService flashCardService = new FlashCardService();
    private TextView scoreTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flashcard);

        imageView = findViewById(R.id.imageView14);
        checkBoxes = new CheckBox[]{
                findViewById(R.id.checkBoxPato),
                findViewById(R.id.checkBoxCachorro),
                findViewById(R.id.checkBoxGato),
                findViewById(R.id.checkBoxDinheiro)
        };
        proximoBtn = findViewById(R.id.proximoBtn);
        finalizarBtn = findViewById(R.id.finalizarBtn);
        scoreTextView = findViewById(R.id.scoreTextView);
        scoreTextView.setText("Pontuação: 0");

        // Inicializa respostas como não respondidas
        for (int i = 0; i < respostasUsuario.length; i++) {
            respostasUsuario[i] = -1;
        }

        atualizarFlashcard();

        proximoBtn.setOnClickListener(v -> {
            int respostaMarcada = getRespostaMarcada();
            if (respostaMarcada == -1) {
                Toast.makeText(this, "Selecione uma alternativa!", Toast.LENGTH_SHORT).show();
                return;
            }
            respostasUsuario[indiceAtual] = respostaMarcada;
            indiceAtual++;
            int corretas = flashCardService.contarRespostasCorretas(flashCards, respostasUsuario);
            int pontuacao = flashCardService.calcularPontuacao(corretas, 10);
            scoreTextView.setText("Pontuação: " + pontuacao);

            if (indiceAtual < flashCards.length) {
                atualizarFlashcard();
            } else {
                mostrarFim();
            }
        });

        finalizarBtn.setOnClickListener(v -> {
            int corretas = flashCardService.contarRespostasCorretas(flashCards, respostasUsuario);
            int pontuacao = flashCardService.calcularPontuacao(corretas, 10);

            // Salva a pontuação no SharedPreferences
            String usuarioId = "usuario1"; // Troque para o ID real do usuário se tiver login
            SharedPreferences prefs = getSharedPreferences("usuario", MODE_PRIVATE);
            prefs.edit().putInt(usuarioId + "_pontuacao", pontuacao).apply();

            scoreTextView.setText("Pontuação: " + pontuacao);

            Toast.makeText(this, "Exercício finalizado! Pontuação: " + pontuacao, Toast.LENGTH_LONG).show();
            finalizarBtn.setEnabled(false);
            proximoBtn.setEnabled(false);
        });
    }

    private void atualizarFlashcard() {
        FlashCardEntity atual = flashCards[indiceAtual];
        imageView.setImageResource(atual.getImagemResId());
        for (int i = 0; i < checkBoxes.length; i++) {
            checkBoxes[i].setText(atual.getAlternativas()[i]);
            checkBoxes[i].setChecked(false);
            checkBoxes[i].setEnabled(true);
            int finalI = i;
            checkBoxes[i].setOnClickListener(v -> {
                // Permite marcar apenas um CheckBox por vez
                for (int j = 0; j < checkBoxes.length; j++) {
                    if (j != finalI) checkBoxes[j].setChecked(false);
                }
            });
        }
        proximoBtn.setEnabled(true);
        finalizarBtn.setEnabled(false);
    }

    private int getRespostaMarcada() {
        for (int i = 0; i < checkBoxes.length; i++) {
            if (checkBoxes[i].isChecked()) return i;
        }
        return -1;
    }

    private void mostrarFim() {
        imageView.setImageResource(0);
        for (CheckBox cb : checkBoxes) {
            cb.setText("");
            cb.setChecked(false);
            cb.setEnabled(false);
        }
        proximoBtn.setEnabled(false);
        finalizarBtn.setEnabled(true);
    }

    // Navegação do menu inferior
    public void home_btn(View view) {
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
        finish();
    }

    public void anotacao_btn(View view) {
        Intent intent = new Intent(this, AnotacaoActivity.class);
        startActivity(intent);
        finish();
    }

    public void traducao_btn(View view) {
        Intent intent = new Intent(this, TraducaoActivity.class);
        startActivity(intent);
        finish();
    }

    public void dicionario_btn(View view) {
        Intent intent = new Intent(this, AulasActivity.class);
        startActivity(intent);
        finish();
    }
}