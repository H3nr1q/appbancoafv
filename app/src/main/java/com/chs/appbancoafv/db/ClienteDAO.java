package com.chs.appbancoafv.db;

import android.database.Cursor;

import com.chs.appbancoafv.model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteDAO  extends DAO<Cliente> {
    public static ClienteDAO instance;

    public ClienteDAO() {

    }

    @Override
    public boolean saveOrEdit(Cliente object) {
        return false;
    }

    @Override
    public List<Cliente> searchByName(String name) {
        return null;
    }

    @Override
    public boolean deletar(Cliente object) {
        return false;
    }

    @Override
    public List<Cliente> listar() {
        return null;
    }

    @Override
    public Cliente searchContactById(int id) {
        return null;
    }

    public synchronized static ClienteDAO getInstance() {
        if (instance == null) {
            instance = new ClienteDAO();
        }
        return instance;
    }

    public List<Cliente> listaClienteCard() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT " +
                "CLI_CODIGOCLIENTE, " +
                "CLI_CGCCPF, " +
                "CLI_RAZAOSOCIAL, " +
                "CLI_NOMEFANTASIA " +
                "FROM GUA_CLIENTES;";

        Cursor c = getReadableDB().rawQuery(sql, null);
        while (c.moveToNext()) {
            Cliente cliente = new Cliente();
            cliente.setCodigo(c.getString(c.getColumnIndex("CLI_CODIGOCLIENTE")));
            cliente.setCgccpf(c.getString(c.getColumnIndex("CLI_CGCCPF")));
            cliente.setRazao(c.getString(c.getColumnIndex("CLI_RAZAOSOCIAL")));
            cliente.setFantasia(c.getString(c.getColumnIndex("CLI_NOMEFANTASIA")));
            clientes.add(cliente);
        }
        c.close();
        return clientes;

    }

    public List<Cliente> buscaCliente(String digitouTexto) {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT " +
                "CLI_CODIGOCLIENTE, " +
                "CLI_CGCCPF, " +
                "CLI_RAZAOSOCIAL, " +
                "CLI_NOMEFANTASIA " +
                "FROM GUA_CLIENTES " +
                "WHERE CLI_CODIGOCLIENTE = " + "'" + digitouTexto + "'" +
                "OR CLI_CGCCPF LIKE " + "'%" + digitouTexto + "%'" +
                "OR CLI_RAZAOSOCIAL LIKE " + "'%" + digitouTexto + "%'" +
                "OR CLI_NOMEFANTASIA LIKE " + "'%" + digitouTexto + "%'" +
                ";";

        Cursor c = getReadableDB().rawQuery(sql, null);
        while (c.moveToNext()) {
            Cliente cliente = new Cliente();
            cliente.setCodigo(c.getString(c.getColumnIndex("CLI_CODIGOCLIENTE")));
            cliente.setCgccpf(c.getString(c.getColumnIndex("CLI_CGCCPF")));
            cliente.setRazao(c.getString(c.getColumnIndex("CLI_RAZAOSOCIAL")));
            cliente.setFantasia(c.getString(c.getColumnIndex("CLI_NOMEFANTASIA")));
            clientes.add(cliente);
        }
        c.close();
        return clientes;

    }
}
