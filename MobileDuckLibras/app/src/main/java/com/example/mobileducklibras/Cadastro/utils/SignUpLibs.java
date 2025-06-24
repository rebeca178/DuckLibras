package com.example.mobileducklibras.Cadastro.utils;


import android.util.Log;

import com.example.mobileducklibras.Cadastro.data.SignUp;
import com.example.mobileducklibras.Cadastro.data.SignUpListener;
import com.example.mobileducklibras.shared.data.ResponseModel;
import com.example.mobileducklibras.shared.utils.RetrofitClient;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpLibs {
    private String resp;
    private final SignUpListener listener;

    public SignUpLibs(SignUpListener listener) {
        this.listener = listener;
    }

    public void SignupUser(SignUp signUp) {
        SignUpService service = RetrofitClient
                .getRetrofitInstance()
                .create(SignUpService.class);

        Call<ResponseModel> call = service.signUpUser(signUp);
        call.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                try {
                    if (!response.isSuccessful()) {
                        handleErrorResponse(response);
                        return;
                    }

                    handleSuccessResponse(response);
                } catch (Exception e) {
                    String errorMsg = "Erro ao processar resposta: " + e.getMessage();
                    Log.e("SignUpError", errorMsg);
                    listener.onSignUpFailure(errorMsg);
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                String errorMsg = "Falha na comunicação: " + t.getMessage();
                Log.e("NetworkFailure", errorMsg);
                listener.onSignUpFailure(errorMsg);
            }
        });
    }

    private void handleErrorResponse(Response<ResponseModel> response) {
        String errorMsg = "Erro desconhecido";

        try {
            if (response.errorBody() != null) {
                errorMsg = response.errorBody().string();
            } else if (response.body() != null && response.body().getResponse() != null) {
                errorMsg = response.body().getResponse();
            } else {
                errorMsg = "Erro " + response.code();
            }
        } catch (IOException e) {
            errorMsg = "Erro ao ler mensagem de erro";
        }

        // Verificação para evitar log de mensagem nula
        Log.e("API_Error", errorMsg != null ? errorMsg : "Mensagem de erro nula");
        listener.onSignUpFailure(errorMsg != null ? errorMsg : "Erro desconhecido");
    }

    private void handleSuccessResponse(Response<ResponseModel> response) {
        if (response.body() != null && response.body().getResponse() != null) {
            String errorMsg = response.body().getResponse();
            Log.e("API_Error", errorMsg);
            listener.onSignUpFailure(errorMsg);
        } else {
            String successMsg = "Enviado Com Sucesso";
            Log.d("API_Success", successMsg);
            listener.onSignUpSuccess(successMsg);
        }
    }

    public String getResp() {
        return this.resp;
    }
}