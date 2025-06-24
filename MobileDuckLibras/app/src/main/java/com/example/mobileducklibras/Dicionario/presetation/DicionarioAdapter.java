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

public class DicionarioAdapter extends RecyclerView.Adapter<DicionarioAdapter.ViewHolder> {
    private List<DicionarioLibrasEntity> lista;

    public DicionarioAdapter(List<DicionarioLibrasEntity> lista) {
        this.lista = lista;
    }

    public void updateList(List<DicionarioLibrasEntity> novaLista) {
        this.lista = novaLista;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dicionario, parent, false);
    return new ViewHolder(v);
}

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    DicionarioLibrasEntity item = lista.get(position);
    holder.wordTextView.setText(item.getPalavra());
    holder.translationTextView.setText(item.getTraducao());
    holder.wordImageView.setImageResource(item.getImagemResId());
}

    @Override
    public int getItemCount() {
        return lista.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
    ImageView wordImageView;
    TextView wordTextView;
    TextView translationTextView;
    ViewHolder(View v) {
        super(v);
        wordImageView = v.findViewById(R.id.wordImageView);
        wordTextView = v.findViewById(R.id.wordTextView);
        translationTextView = v.findViewById(R.id.translationTextView);
    }
}
}