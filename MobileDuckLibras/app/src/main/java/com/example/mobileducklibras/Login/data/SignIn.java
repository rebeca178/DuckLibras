package com.example.mobileducklibras.Login.data;

public class SignIn {
    private String usernameOrEmail;
    private String pass;

    public void setUsernameOrEmail(String usernameOrEmail){
        this.usernameOrEmail = usernameOrEmail;
    }
    public String getUsernameOrEmail(){
        return this.usernameOrEmail;
    }

    public void setPass(String pass){
        this.pass = pass;
    }

    public String getPass(){
        return this.pass;
    }

}
