package com.example.mobileducklibras.Dicionario.presetation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobileducklibras.Dicionario.data.DicionarioLibrasEntity;
import com.example.mobileducklibras.R;

import java.util.List;

import com.bumptech.glide.Glide;
public class DicionarioAdapter extends RecyclerView.Adapter<DicionarioAdapter.DicionarioViewHolder> {

    private List<DicionarioLibrasEntity> dicionarioList;

    public DicionarioAdapter(List<DicionarioLibrasEntity> dicionarioList) {
        this.dicionarioList = dicionarioList;
    }

    // Método para atualizar a lista de dados e notificar o adaptador
    public void updateList(List<DicionarioLibrasEntity> newList) {
        this.dicionarioList = newList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DicionarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dicionario, parent, false);
        return new DicionarioViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DicionarioViewHolder holder, int position) {
        DicionarioLibrasEntity dicionarioItem = dicionarioList.get(position);
        holder.wordTextView.setText(dicionarioItem.getPalavra());
        holder.translationTextView.setText(dicionarioItem.getTraducao());

        // Carrega a imagem usando Glide, se a URL da imagem não for nula
        if (dicionarioItem.getImagem() != null && !dicionarioItem.getImagem().isEmpty()) {
            Glide.with(holder.itemView.getContext())
                    .load(dicionarioItem.getImagem())
                    .placeholder(R.drawable.ic_libras) // Imagem placeholder enquanto carrega
                    .error(R.drawable.ic_libras)     // Imagem de erro se falhar
                    .into(holder.wordImageView);
        } else {
            // Define uma imagem padrão se não houver URL de imagem
            holder.wordImageView.setImageResource(R.drawable.ic_libras);
        }

        // Você pode adicionar um OnClickListener para cada item se quiser lidar com cliques
        holder.itemView.setOnClickListener(v -> {
            // Exemplo: Toast com a palavra clicada
            // Toast.makeText(v.getContext(), "Clicou em: " + dicionarioItem.getPalavra(), Toast.LENGTH_SHORT).show();
            // Ou iniciar uma nova Activity com detalhes da palavra
        });
    }

    @Override
    public int getItemCount() {
        return dicionarioList.size();
    }

    public static class DicionarioViewHolder extends RecyclerView.ViewHolder {
        TextView wordTextView;
        TextView translationTextView;
        ImageView wordImageView;
        // Se você tiver um ícone de favorito no item, pode adicioná-lo aqui:
        // ImageView favoriteIcon;

        public DicionarioViewHolder(@NonNull View itemView) {
            super(itemView);
            wordTextView = itemView.findViewById(R.id.wordTextView);
            translationTextView = itemView.findViewById(R.id.translationTextView);
            wordImageView = itemView.findViewById(R.id.wordImageView);
            // favoriteIcon = itemView.findViewById(R.id.favoriteIcon); // Se existir
        }
    }
}