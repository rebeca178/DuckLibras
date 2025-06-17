package com.example.mobileducklibras.shared.services;

import com.example.mobileducklibras.user.data.AlunoEntity;
import com.example.mobileducklibras.shared.data.ResponseModel; // Certifique-se que ResponseModel é genérico

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path; // Para buscar perfil por ID, se necessário

public interface ProfileService {

    // Exemplo: Buscar o perfil do usuário logado (assumindo que o backend identifique o usuário pelo token)
    @GET("/alunos/profile") // Adapte este endpoint para o seu backend
    Call<ResponseModel<AlunoEntity>> getUserProfile();

    // Outra opção: Buscar perfil por ID (se você passar o ID do usuário)
    @GET("/alunos/{id}") // Adapte este endpoint
    Call<ResponseModel<AlunoEntity>> getUserProfileById(@Path("id") Long userId);
}