package com.example.mobileducklibras.Cadastro.utils;


import com.example.mobileducklibras.Cadastro.data.SignUp;
import com.example.mobileducklibras.shared.data.ResponseModel;

import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.Call;
public interface SignUpService {

    @POST("cad/signup")
    Call<ResponseModel> signUpUser(@Body SignUp signup);
}
