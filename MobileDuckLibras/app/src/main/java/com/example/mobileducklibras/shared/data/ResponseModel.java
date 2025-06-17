package com.example.mobileducklibras.shared.data;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

// A classe ResponseModel DEVE ser genérica com o tipo <T>
public class ResponseModel<T> implements Serializable {

    // Campo para armazenar os dados da resposta, do tipo genérico T
    @SerializedName("data")
    private T data;

    @SerializedName("success")
    private boolean success;

    @SerializedName("message")
    private String message;

    public ResponseModel() {
    }

    public ResponseModel(T data, boolean success, String message) {
        this.data = data;
        this.success = success;
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}