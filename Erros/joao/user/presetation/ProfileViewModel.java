package com.example.mobileducklibras.user.presetation;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mobileducklibras.user.data.AlunoEntity;
import com.example.mobileducklibras.shared.data.ResponseModel;
import com.example.mobileducklibras.shared.services.ProfileService;
import com.example.mobileducklibras.shared.utils.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileViewModel extends ViewModel {

    private MutableLiveData<AlunoEntity> userProfile = new MutableLiveData<>();
    private MutableLiveData<String> errorMessage = new MutableLiveData<>();
    private ProfileService profileService;

    public ProfileViewModel() {
        profileService = RetrofitClient.getRetrofitInstance().create(ProfileService.class);
    }

    public LiveData<AlunoEntity> getUserProfile() {
        return userProfile;
    }

    public LiveData<String> getErrorMessage() {
        return errorMessage;
    }

    public void loadUserProfile() {
        // Chamada para buscar o perfil do usuário logado (usando o endpoint sem ID)
        Call<ResponseModel<AlunoEntity>> call = profileService.getUserProfile();
        call.enqueue(new Callback<ResponseModel<AlunoEntity>>() {
            @Override
            public void onResponse(Call<ResponseModel<AlunoEntity>> call, Response<ResponseModel<AlunoEntity>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    if (response.body().isSuccess()) { // Se o ResponseModel tem campo 'success'
                        userProfile.setValue(response.body().getData());
                        errorMessage.setValue(null); // Limpa qualquer erro anterior
                    } else {
                        errorMessage.setValue(response.body().getMessage() != null ? response.body().getMessage() : "Falha ao carregar perfil.");
                    }
                } else {
                    errorMessage.setValue("Erro ao carregar perfil: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<ResponseModel<AlunoEntity>> call, Throwable t) {
                errorMessage.setValue("Erro de rede: " + t.getMessage());
            }
        });
    }

    // Opcional: para carregar perfil por ID, se necessário
    public void loadUserProfileById(Long userId) {
        Call<ResponseModel<AlunoEntity>> call = profileService.getUserProfileById(userId);
        call.enqueue(new Callback<ResponseModel<AlunoEntity>>() {
            @Override
            public void onResponse(Call<ResponseModel<AlunoEntity>> call, Response<ResponseModel<AlunoEntity>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    if (response.body().isSuccess()) {
                        userProfile.setValue(response.body().getData());
                        errorMessage.setValue(null);
                    } else {
                        errorMessage.setValue(response.body().getMessage() != null ? response.body().getMessage() : "Falha ao carregar perfil por ID.");
                    }
                } else {
                    errorMessage.setValue("Erro ao carregar perfil por ID: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<ResponseModel<AlunoEntity>> call, Throwable t) {
                errorMessage.setValue("Erro de rede ao carregar perfil por ID: " + t.getMessage());
            }
        });
    }
}