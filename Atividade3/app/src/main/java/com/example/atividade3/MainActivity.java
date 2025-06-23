package com.example.atividade3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> elementos;
    private ListarAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        elementos = new ArrayList<>();
        adapter = new ListarAdapter(elementos);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        EditText editTextNumero = findViewById(R.id.editTextNumero);
        Button buttonAdicionar = findViewById(R.id.buttonAdicionar);

        buttonAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String valor = editTextNumero.getText().toString().trim();
                if (!valor.isEmpty()) {
                    elementos.add(valor);
                    adapter.notifyItemInserted(elementos.size() - 1);
                    editTextNumero.setText("");
                }
            }
        });
    }
}