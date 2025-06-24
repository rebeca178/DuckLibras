package com.example.mobileducklibras.shared.service;

import com.example.mobileducklibras.user.data.AlunoEntity;
import com.example.mobileducklibras.shared.data.ApiResult; // Altere para o novo nome

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path; // Para buscar perfil por ID, se necessário

public interface ProfileService {

    // Buscar o perfil do usuário logado
    @GET("/alunos/profile")
    Call<ApiResult<AlunoEntity>> getUserProfile();

    // Buscar perfil por ID
    @GET("/alunos/{id}")
    Call<ApiResult<AlunoEntity>> getUserProfileById(@Path("id") Long userId);
}