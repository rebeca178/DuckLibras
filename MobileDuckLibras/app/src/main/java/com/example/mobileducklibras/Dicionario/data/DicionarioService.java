package com.example.mobileducklibras.Dicionario.data;

import com.example.mobileducklibras.shared.data.ApiResult;
import com.example.mobileducklibras.shared.data.ResponseModel;
import com.example.mobileducklibras.Dicionario.data.DicionarioLibrasEntity; // Importe a entidade

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface DicionarioService {
    @GET("/dicionario/all")
    Call<ApiResult<List<DicionarioLibrasEntity>>> getAllDicionario(); // Tipo especificado aqui
}