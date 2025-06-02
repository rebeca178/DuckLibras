package com.example.mobileducklibras.Cadastro.utils;


import com.example.mobileducklibras.Cadastro.data.SignUp;
import com.example.mobileducklibras.shared.utils.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpLibs {

    private String resp;
    public SignUpLibs(){}

    public String SignUpUser(SignUp signup)
    {
        SignUpService service = RetrofitClient
                .getRetrofitInstance()
                .create(SignUpService.class);
        Call<String> call = service.SignUpUser(signup);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful())
                {
                    resp = response.body();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

                resp = "Não foi possivel cadastrar o usuario";

            }
        });

        return resp;
    }
}