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

    private final SignInListener listener = new SignInListener() {
        @Override
        public void onSignInSucess(String response) {

        }

        @Override
        public void onSignInFailure(String response) {

        }
    };
    public void SignInUser(SignIn signIn){

        SignInService service = RetrofitClient.getRetrofitInstance().create(SignInService.class);

        Call<ResponseModel> call = service.signUpUser(signIn);

        call.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                if (!response.isSuccessful()){
                    String aux = response.body().getResponse();
                    Log.e("Login sem sucesso",aux);
                    resp = aux;
                    listener.onSignInSucess(aux);
                }
                String aux = response.body().getResponse();
                Log.e("Mensagem esperada: ",aux);
                resp = aux;
                listener.onSignInSucess(aux);
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Log.e("Falha de envio",t.toString());

            }
        });
    }
    public String getResp(){
        return  this.resp;
    }
}
