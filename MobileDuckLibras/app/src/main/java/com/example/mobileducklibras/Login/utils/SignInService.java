package com.example.mobileducklibras.Login.utils;

import com.example.mobileducklibras.Login.data.SignIn;
import com.example.mobileducklibras.shared.data.ResponseModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface SignInService {
    @POST("cad/signin")
    Call<ResponseModel> signUpUser(@Body SignIn signIn);
}
