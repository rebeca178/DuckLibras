package com.example.mobileducklibras.Dicionario.presetation;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mobileducklibras.Dicionario.data.DicionarioLibrasEntity;
import com.example.mobileducklibras.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DicionarioViewModel extends ViewModel {

    private final MutableLiveData<List<DicionarioLibrasEntity>> dicionarioList = new MutableLiveData<>();
    private final MutableLiveData<String> error = new MutableLiveData<>();
    private List<DicionarioLibrasEntity> fullDicionarioList = new ArrayList<>();

    public DicionarioViewModel() {
        // Inicialização, se necessário
    }

    public LiveData<List<DicionarioLibrasEntity>> getDicionarioList() {
        return dicionarioList;
    }

    public LiveData<String> getError() {
        return error;
    }

    public void loadDicionario() {
        // MODO OFFLINE: Adiciona itens automaticamente ao abrir o dicionário, agora com imagens
        fullDicionarioList = new ArrayList<>();
        fullDicionarioList.add(new DicionarioLibrasEntity("Letra A", "Letra A", "Letra A", R.drawable.a));
        fullDicionarioList.add(new DicionarioLibrasEntity("Letra E", "Letra E", "Letra E", R.drawable.e));
        fullDicionarioList.add(new DicionarioLibrasEntity("Letra I", "Letra I", "Letra I", R.drawable.i));
        fullDicionarioList.add(new DicionarioLibrasEntity("Letra O", "Letra O", "Letra O", R.drawable.o));
        fullDicionarioList.add(new DicionarioLibrasEntity("Letra U", "Letra U", "Letra U", R.drawable.u));


        dicionarioList.setValue(fullDicionarioList);
        error.setValue(null);
    }

    public void filterDicionario(String query) {
        if (fullDicionarioList == null || fullDicionarioList.isEmpty()) {
            return;
        }

        if (query == null || query.isEmpty()) {
            dicionarioList.setValue(fullDicionarioList);
        } else {
            String lowerCaseQuery = query.toLowerCase(Locale.getDefault());
            List<DicionarioLibrasEntity> filteredList = new ArrayList<>();
            for (DicionarioLibrasEntity item : fullDicionarioList) {
                String palavra = item.getPalavra() != null ? item.getPalavra().toLowerCase(Locale.getDefault()) : "";
                String traducao = item.getTraducao() != null ? item.getTraducao().toLowerCase(Locale.getDefault()) : "";
                String descricao = item.getDescricao() != null ? item.getDescricao().toLowerCase(Locale.getDefault()) : "";
                if (palavra.contains(lowerCaseQuery) || traducao.contains(lowerCaseQuery) || descricao.contains(lowerCaseQuery)) {
                    filteredList.add(item);
                }
            }
            dicionarioList.setValue(filteredList);
        }
    }
}