package com.example.mobileducklibras.shared.data;

public class ResponseModel {
    private String response;
    public String message;

    public int status;

    public void setResponse(String response) {
        this.response = response;
    }

    public String getResponse() {
        return this.response;
    }

    public void setMessage(String message){
        this.message = message;
    }
    public String getMessage() {
        return this.message;
    }

    public void setStatus(int status){
        this.status = status;

    }
    public int getStatus() {
        return this.status;
    }
}

