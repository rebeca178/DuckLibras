package com.example.mobileducklibras.Cadastro.data;


public interface SignUpListener
{
    void onSignUpSuccess(String response);
    void onSignUpFailure(String response);
}