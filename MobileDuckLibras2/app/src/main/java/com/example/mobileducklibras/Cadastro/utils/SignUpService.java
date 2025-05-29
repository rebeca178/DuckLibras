package com.example.mobileducklibras.Cadastro.utils;

import android.telecom.Call;

import com.example.mobileducklibras.Cadastro.data.SignUp;

import retrofit2.http.Body;
import retrofit2.http.POST;

public interface SignUpService {

    @POST("cad/signup")
    retrofit2.Call<String> SignUpUser(@Body SignUp signUp);
}
