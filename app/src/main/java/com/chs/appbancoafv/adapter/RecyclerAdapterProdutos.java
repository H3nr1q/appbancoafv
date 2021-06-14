package com.chs.appbancoafv.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.chs.appbancoafv.R;
import com.chs.appbancoafv.model.Produto;

import java.util.List;

public class RecyclerAdapterProdutos extends RecyclerView.Adapter<RecyclerAdapterProdutos.ProdutoViewHolder> {
    private List<Produto> produtoList;
    private OnClickProduto onClickProduto;

    public OnClickProduto getOnClickProduto() {
        return onClickProduto;
    }

    public void setOnClickProduto(OnClickProduto onClickProduto) {
        this.onClickProduto = onClickProduto;
    }

    public RecyclerAdapterProdutos(List<Produto> produtoList) {
        this.produtoList = produtoList;
    }

    @Override
    public ProdutoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_produto,parent, false);
        return new ProdutoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProdutoViewHolder holder, int position) {
        Produto produto = produtoList.get(position);
        holder.proCodigo.setText(produto.getCODIGO());
        holder.proDescricao.setText(produto.getDESCRICAO());
        holder.proEstoque.setText(produto.getESTOQUE());
        holder.proLegenda.setText(produto.getLEGENDA());
        holder.proVrMin.setText(produto.getVRMIN());
        holder.proVrMax.setText(produto.getVRMAX());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickProduto.setOnProdutoListener(position, produtoList.get(position));

            }
        });

    }

    @Override
    public int getItemCount() {
        return produtoList.size();
    }

    public static class ProdutoViewHolder extends RecyclerView.ViewHolder{

        public TextView proCodigo;
        public TextView proDescricao;
        public TextView proLegenda;
        public TextView proVrMax;
        public TextView proVrMin;
        public TextView proEstoque;


        public ProdutoViewHolder(View itemView) {
            super(itemView);
            proCodigo = itemView.findViewById(R.id.txtCodigo);
            proDescricao = itemView.findViewById(R.id.txtDescricao);
            proEstoque = itemView.findViewById(R.id.txtQtdeEstoque);
            proLegenda = itemView.findViewById(R.id.txtDescLegenda);
            proVrMax = itemView.findViewById(R.id.txtSetVrMax);
            proVrMin = itemView.findViewById(R.id.txtSetVrMin);
        }
    }


    public interface OnClickProduto{
        void setOnProdutoListener(int position, Produto produto);
    }
}
