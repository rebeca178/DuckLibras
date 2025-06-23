package com.example.atividade3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ListarAdapter extends RecyclerView.Adapter<ListarAdapter.ViewHolder> {
    private List<String> elementos;

    public ListarAdapter(List<String> elementos) {
        this.elementos = elementos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_lista, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textoItem.setText(elementos.get(position));
    }

    @Override
    public int getItemCount() {
        return elementos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textoItem;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textoItem = itemView.findViewById(R.id.textoItem);
        }
    }
}