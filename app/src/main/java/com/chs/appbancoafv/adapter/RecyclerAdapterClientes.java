package com.chs.appbancoafv.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chs.appbancoafv.R;
import com.chs.appbancoafv.model.Cliente;

import java.util.List;

public class RecyclerAdapterClientes extends RecyclerView.Adapter<RecyclerAdapterClientes.ClienteViewHolder> {
    private List<Cliente> clienteList;

    public RecyclerAdapterClientes(List<Cliente> clienteList){
        this.clienteList = clienteList;

    }

    @Override
    public ClienteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_cliente, parent, false);
        return new ClienteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ClienteViewHolder holder, int position) {
        Cliente cliente = clienteList.get(position);
        holder.cliCodigo.setText(cliente.getCodigo());
        holder.cliCnpjcpf.setText(cliente.getCgccpf());
        holder.cliRazao.setText(cliente.getRazao());
        holder.cliFantasia.setText(cliente.getFantasia());
    }

    @Override
    public int getItemCount() {
        return clienteList.size();
    }

    public class ClienteViewHolder extends RecyclerView.ViewHolder{
        public TextView cliCodigo;
        public TextView cliRazao;
        public TextView cliFantasia;
        public TextView cliCnpjcpf;
        public ImageView imgEditarExcluir;

        public ClienteViewHolder(View itemView) {

            super(itemView);
            cliCodigo = itemView.findViewById(R.id.txtCliCodigo);
            cliRazao = itemView.findViewById(R.id.txtCliRazao);
            cliFantasia = itemView.findViewById(R.id.txtCliFantasia);
            cliCnpjcpf = itemView.findViewById(R.id.txtCnpjCpf);
            imgEditarExcluir = itemView.findViewById(R.id.imgEditarExcluir);
        }
    }
}
