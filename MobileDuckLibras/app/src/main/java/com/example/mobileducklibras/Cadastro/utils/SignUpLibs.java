package com.example.mobileducklibras.Cadastro.utils;


import android.util.Log;

import com.example.mobileducklibras.Cadastro.data.SignUp;
import com.example.mobileducklibras.Cadastro.data.SignUpListener;
import com.example.mobileducklibras.shared.data.ResponseModel;
import com.example.mobileducklibras.shared.utils.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpLibs {
    String resp;
    final SignUpListener listener = new SignUpListener() {
        @Override
        public void onSignUpSuccess(String response) {

        }

        @Override
        public void onSignUpFailure(String response) {

        }
    };
    public SignUpLibs (){}
    public void SignupUser(SignUp signUp){
        SignUpService service = RetrofitClient
                .getRetrofitInstance()
                .create(SignUpService.class);
        Call<ResponseModel> call = service.SignUpUser(signUp);
        call.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
            if(!response.isSuccessful()){
                String aux = response.body().getResponse();
                Log.e("Resposta Sem Sucesso",aux);
                resp = aux;
                listener.onSignUpFailure(aux);

            }
            String aux = response.body().getResponse();
            Log.e("Mensagem esperada",aux);
            resp = aux;
            listener.onSignUpSuccess(aux);
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
            Log.e("falha de envio",t.toString());
            }
        });
    }
    public String getResp()
    {
        return this.resp;
    }
}