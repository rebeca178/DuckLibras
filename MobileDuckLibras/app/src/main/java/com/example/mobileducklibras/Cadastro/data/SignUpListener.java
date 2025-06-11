package com.example.mobileducklibras.Cadastro.data;

public abstract class SignUpListener {

    public abstract void onSignUpSuccess(String response);

    public abstract void onSignUpFailure(String response);
}