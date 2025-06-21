package com.example.mobileducklibras.Dicionario.presetation;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mobileducklibras.Dicionario.data.DicionarioLibrasEntity;
import com.example.mobileducklibras.Dicionario.data.DicionarioService;
import com.example.mobileducklibras.shared.utils.RetrofitClient;
import com.example.mobileducklibras.shared.data.ApiResult; // Alterado para ApiResult

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DicionarioViewModel extends ViewModel {

    private MutableLiveData<List<DicionarioLibrasEntity>> dicionarioList = new MutableLiveData<>();
    private MutableLiveData<String> error = new MutableLiveData<>();
    private List<DicionarioLibrasEntity> fullDicionarioList = new ArrayList<>();

    private DicionarioService dicionarioService;

    public DicionarioViewModel() {
        dicionarioService = RetrofitClient.getRetrofitInstance().create(DicionarioService.class);
    }

    public LiveData<List<DicionarioLibrasEntity>> getDicionarioList() {
        return dicionarioList;
    }

    public LiveData<String> getError() {
        return error;
    }

    public void loadDicionario() {
        Call<ApiResult<List<DicionarioLibrasEntity>>> call = dicionarioService.getAllDicionario();
        call.enqueue(new Callback<ApiResult<List<DicionarioLibrasEntity>>>() {
            @Override
            public void onResponse(Call<ApiResult<List<DicionarioLibrasEntity>>> call, Response<ApiResult<List<DicionarioLibrasEntity>>> response) {
                if (response.isSuccessful() && response.body() != null && response.body().getData() != null) {
                    fullDicionarioList = response.body().getData();
                    dicionarioList.setValue(fullDicionarioList);
                    error.setValue(null);
                } else {
                    error.setValue("Falha ao carregar dicionário: " + response.message());
                    dicionarioList.setValue(new ArrayList<>());
                }
            }

            @Override
            public void onFailure(Call<ApiResult<List<DicionarioLibrasEntity>>> call, Throwable t) {
                error.setValue("Erro de rede: " + t.getMessage());
                dicionarioList.setValue(new ArrayList<>());
            }
        });
    }

    public void filterDicionario(String query) {
        if (fullDicionarioList == null || fullDicionarioList.isEmpty()) {
            return;
        }

        if (query.isEmpty()) {
            dicionarioList.setValue(fullDicionarioList);
        } else {
            String lowerCaseQuery = query.toLowerCase(Locale.getDefault());
            List<DicionarioLibrasEntity> filteredList = fullDicionarioList.stream()
                    .filter(item ->
                            item.getPalavra().toLowerCase(Locale.getDefault()).contains(lowerCaseQuery) ||
                                    item.getTraducao().toLowerCase(Locale.getDefault()).contains(lowerCaseQuery) ||
                                    (item.getDescricao() != null && item.getDescricao().toLowerCase(Locale.getDefault()).contains(lowerCaseQuery))
                    )
                    .collect(Collectors.toList());
            dicionarioList.setValue(filteredList);
        }
    }
}