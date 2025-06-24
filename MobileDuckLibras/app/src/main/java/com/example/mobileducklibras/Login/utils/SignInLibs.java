package com.example.mobileducklibras.Login.utils;

import android.util.Log;

import com.example.mobileducklibras.Login.data.SignIn;
import com.example.mobileducklibras.Login.data.SignInListener;
import com.example.mobileducklibras.shared.data.ResponseModel;
import com.example.mobileducklibras.shared.utils.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignInLibs {
    private String resp;
    private final SignInListener listener;

    // Agora recebe o listener por construtor
    public SignInLibs(SignInListener listener){
        this.listener = listener;
    }

    public void SignInUser(SignIn signin)
    {
        SignInService service = RetrofitClient
                .getRetrofitInstance()
                .create(SignInService.class);
        Call<ResponseModel> call = service.signInUser(signin); // Corrija para signInUser
        call.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                if (response.body() == null) {
                    String errorMsg = "Erro desconhecido ao fazer login";
                    if (response.errorBody() != null) {
                        try {
                            errorMsg = response.errorBody().string();
                        } catch (Exception e) {
                            errorMsg = "Erro ao ler corpo de erro";
                        }
                    }
                    Log.e("Login Sem Sucesso", errorMsg);
                    resp = errorMsg;
                    listener.onSignInFailure(errorMsg);
                    return;
                }

                ResponseModel body = response.body();
                String aux = body.getResponse();
                if (aux == null) {
                    aux = body.getMessage();
                }

                if (!response.isSuccessful() || body.getStatus() != 200) {
                    Log.e("Login Sem Sucesso", aux);
                    resp = aux;
                    listener.onSignInFailure(aux);
                    return;
                }

                Log.e("Mensagem esperada: ", aux);
                resp = aux;
                listener.onSignInSucess(aux);
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Log.e("Falha de envio: ", t.toString());
                listener.onSignInFailure("Falha de conexão: " + t.getMessage());
            }
        });
    }

    public String getResp(){
        return this.resp;
    }
}