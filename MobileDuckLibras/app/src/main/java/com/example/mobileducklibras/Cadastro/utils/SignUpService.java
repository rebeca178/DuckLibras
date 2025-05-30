package com.example.mobileducklibras.Cadastro.utils;


import com.example.mobileducklibras.Cadastro.data.SignUp;

import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.Call;
public interface SignUpService {

    @POST("cad/signup")
    Call<String> SignUpUser(@Body SignUp signup);
}
