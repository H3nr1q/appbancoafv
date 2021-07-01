package com.chs.appbancoafv.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.Toast;

import com.chs.appbancoafv.R;
import com.chs.appbancoafv.adapter.RecyclerAdapterClientes;
import com.chs.appbancoafv.db.ClienteDAO;
import com.chs.appbancoafv.model.Cliente;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class ListaClientesFragment extends Fragment {
    private RecyclerView recyclerView;
    private List<Cliente> clientes = new ArrayList<>();
    private List<Cliente> clientesFiltrados = new ArrayList<>();
    private FloatingActionButton fabCadCliente;


    public ListaClientesFragment() {
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lista_clientes, container, false);

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_busca, menu);
        SearchView sv = (SearchView) menu.findItem(R.id.app_bar_search).getActionView();
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String digitouTexto) {
                clientes = ClienteDAO.getInstance().buscaCliente(digitouTexto);
                clientesFiltrados.addAll(clientes);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                RecyclerAdapterClientes adapterClientes = new RecyclerAdapterClientes(clientes);
                recyclerView.setAdapter(adapterClientes);
                return false;
            }
        });
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.rvClientes);
        clientes = ClienteDAO.getInstance().listaClienteCard();
        clientesFiltrados.addAll(clientes);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerAdapterClientes adapterClientes = new RecyclerAdapterClientes(clientes);
        recyclerView.setAdapter(adapterClientes);

        fabCadCliente = view.findViewById(R.id.fab);
        fabCadCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogNewCliente dialogNewCliente = DialogNewCliente.newInstance();

                /* 3 - Seta o ouvinte que irá escutar o dialog */
                dialogNewCliente.setOnCriarNovoClienteListener(new DialogNewCliente.OnCriarNovoClienteListener() {
                    @Override
                    public void onCriarNovoCliente(Cliente cliente) {
                        Toast.makeText(
                                requireContext(),
                                "TIPO PESSOA SELECIONADO: " + cliente.getTipoPessoa() ,
                                Toast.LENGTH_SHORT
                        ).show();

                        Intent intent = new Intent(getActivity(), CadastroClienteActivity.class);
                        intent.putExtra("tipoPessoa",cliente.getTipoPessoa());
                        intent.putExtra("cgccpf", cliente.getCgccpf());
                        startActivity(intent);
                    }
                });

                dialogNewCliente.show(getActivity().getSupportFragmentManager(), null);

            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        clientes = ClienteDAO.getInstance().listaClienteCard();
        clientesFiltrados.clear();
        clientesFiltrados.addAll(clientes);
    }
}