package com.example.mobileducklibras.Anotacao.utils;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobileducklibras.Anotacao.data.AnotacaoModel;
import com.example.mobileducklibras.R;
import java.util.List;

public class AnotacaoAdapter extends RecyclerView.Adapter<AnotacaoAdapter.ViewHolder> {
    private List<AnotacaoModel> lista;

    public AnotacaoAdapter(List<AnotacaoModel> lista) {
        this.lista = lista;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_anotacao, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AnotacaoModel item = lista.get(position);
        holder.titulo.setText(item.getTitulo());
        holder.conteudo.setText(item.getConteudo());
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView titulo, conteudo;
        public ViewHolder(View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.titulo_item);
            conteudo = itemView.findViewById(R.id.conteudo_item);
        }
    }
}