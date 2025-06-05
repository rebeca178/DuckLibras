package Dicionario.presetation;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ducklibras.R;


import java.util.List;

import Dicionario.Data.SignItem;
import Dicionario.Utils.DummyData;

public class Dicionario extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SignAdapter adapter;
    private List<SignItem> signList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dicionario);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        signList = DummyData.getSigns();
        adapter = new SignAdapter(signList);
        recyclerView.setAdapter(adapter);
    }
}