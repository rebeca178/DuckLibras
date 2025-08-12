package com.example.mobileducklibras.Anotacao.presetation;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobileducklibras.Anotacao.data.AnotacaoModel;
import com.example.mobileducklibras.Anotacao.utils.AnotacaoAdapter;
import com.example.mobileducklibras.Dicionario.presetation.DicionarioActivity;
import com.example.mobileducklibras.FlashCard.presetation.FlashcardActivity;
import com.example.mobileducklibras.Home.Home;
import com.example.mobileducklibras.R;
import com.example.mobileducklibras.Traducao.TraducaoActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class AnotacaoActivity extends AppCompatActivity {

    private EditText campoTitulo, campoConteudo;
    private RecyclerView recyclerView;
    private AnotacaoAdapter adapter;
    private List<AnotacaoModel> listaAnotacoes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anotacao);

        campoTitulo = findViewById(R.id.tituloAnotacao);
        campoConteudo = findViewById(R.id.campoAnotacao);
        recyclerView = findViewById(R.id.recyclerViewAnotacoes);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new AnotacaoAdapter(listaAnotacoes);
        recyclerView.setAdapter(adapter);

        carregarAnotacoes();
    }

    // Método chamado pelo botão "Salvar" via android:onClick="salvarAnotacao"
    public void salvarAnotacao(View view) {
        String titulo = campoTitulo.getText().toString().trim();
        String conteudo = campoConteudo.getText().toString().trim();
        if (!titulo.isEmpty() && !conteudo.isEmpty()) {
            AnotacaoModel anotacao = new AnotacaoModel(titulo, conteudo);
            listaAnotacoes.add(anotacao);
            salvarAnotacoes();
            adapter.notifyDataSetChanged();
            campoConteudo.setText("");
            campoTitulo.setText("");
        } else {
            Toast.makeText(this, "Preencha o título e a anotação!", Toast.LENGTH_SHORT).show();
        }
    }

    private void salvarAnotacoes() {
        SharedPreferences prefs = getSharedPreferences("anotacoes", MODE_PRIVATE);
        JSONArray array = new JSONArray();
        for (AnotacaoModel a : listaAnotacoes) {
            JSONObject obj = new JSONObject();
            try {
                obj.put("titulo", a.getTitulo());
                obj.put("conteudo", a.getConteudo());
                array.put(obj);
            } catch (Exception ignored) {}
        }
        prefs.edit().putString("lista", array.toString()).apply();
    }

    private void carregarAnotacoes() {
        SharedPreferences prefs = getSharedPreferences("anotacoes", MODE_PRIVATE);
        String json = prefs.getString("lista", "[]");
        try {
            JSONArray array = new JSONArray(json);
            for (int i = 0; i < array.length(); i++) {
                JSONObject obj = array.getJSONObject(i);
                listaAnotacoes.add(new AnotacaoModel(obj.getString("titulo"), obj.getString("conteudo")));
            }
        } catch (Exception ignored) {}
    }

    // Métodos de navegação do menu inferior
    public void home_btn(View view) {
        startActivity(new Intent(this, Home.class));
        finish();
    }

    public void flashcard_btn(View view) {
        startActivity(new Intent(this, FlashcardActivity.class));
        finish();
    }

    public void anotacao_btn(View view) {
        // Já está na tela de anotação
    }

    public void traducao_btn(View view) {
        startActivity(new Intent(this, TraducaoActivity.class));
        finish();
    }

    public void dicionario_btn(View view) {
        startActivity(new Intent(this, DicionarioActivity.class));
        finish();
    }
}