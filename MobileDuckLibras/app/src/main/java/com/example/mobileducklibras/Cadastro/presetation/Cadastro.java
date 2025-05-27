package com.example.mobileducklibras.Cadastro.presetation;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.mobileducklibras.Cadastro.data.SignUp;
import com.example.mobileducklibras.Cadastro.utils.SignUpService;
import com.example.mobileducklibras.R;
import com.example.mobileducklibras.shared.utils.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Cadastro extends AppCompatActivity {
    private String resp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cadastro);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        SignUpService service = RetrofitClient
                .getRetrofitInstance()
                .create(SignUpService.class);

        SignUp signUp = new SignUp();
        retrofit2.Call<String> call = service.SignUpUser(signUp);
        call.enqueue(new Callback<String>(){
            @Override
            public void onResponse(retrofit2.Call<String> call, Response<String> response){
                if(response.isSuccessful())
                {
                    resp = response.body();
                }
            }
            @Override
            public void onFailure(Call<String> call, Throwable t){
                resp = "User Não Encontrado";
            }

     });

    }
}