package com.chs.appbancoafv.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chs.appbancoafv.R;
import com.chs.appbancoafv.model.Produto;

import java.util.List;

public class RecyclerDialogPrecos extends RecyclerView.Adapter<RecyclerDialogPrecos.PrecosViewHolder> {
    private List<Produto> produtoListPreco;

    public RecyclerDialogPrecos(List<Produto> produtoListPreco){
        this.produtoListPreco = produtoListPreco;

    }

    @Override
    public PrecosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_dialog_precos_produto, parent, false);
        return new PrecosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PrecosViewHolder holder, int position) {
        Produto produto = produtoListPreco.get(position);
        holder.preTabela.setText(produto.getTabela());
        holder.preEmbalagem.setText(produto.getEmbalagem());
        holder.prePreco.setText(produto.getPreco());

    }

    @Override
    public int getItemCount() {
        return produtoListPreco.size();
    }


    public static class PrecosViewHolder extends RecyclerView.ViewHolder {
        private TextView preTabela;
        private TextView prePreco;
        private TextView preEmbalagem;



        public PrecosViewHolder(View itemView) {
            super(itemView);
            preTabela = itemView.findViewById(R.id.txtSetNomeTabela);
            prePreco = itemView.findViewById(R.id.txtSetPreco);
            preEmbalagem = itemView.findViewById(R.id.txtSetEmbalagem);

        }
    }
}
