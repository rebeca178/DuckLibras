package com.example.mobileducklibras.Cadastro.data;

public class SignUp {
    private String username;

    private String email;

    private String password;

    public void setName(String username){

        this.username = username;
    }
    public String getName()
    {

        return this.username;
    }
    public void setEmail(String email){

        this.email = email;
    }
    public String getEmail(){

        return this.email;
    }

    public void setPassword(String password){

        this.password = password;
    }
    public String getPassword()
    {
        return this.password;
    }

    public SignUp(){}

}
