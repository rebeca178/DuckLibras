package com.example.mobileducklibras.Login.data;

public interface SignInListener {
    void onSignInSucess(String response);

    void onSignInFailure(String response);
}
