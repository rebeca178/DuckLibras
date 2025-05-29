package com.example.mobileducklibras.Cadastro.data;

public class SignUp {
    private String name;

    private String email;

    private String password;

    private String photo;

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
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
    public String getPassword(){
        return this.password;
    }

    public void setPhoto(){
        this.photo = photo;
    }
    public String getPhoto(){
        return this.photo;
    }
}
