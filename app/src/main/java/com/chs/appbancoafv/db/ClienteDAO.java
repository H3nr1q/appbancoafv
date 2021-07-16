package com.chs.appbancoafv.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.chs.appbancoafv.model.Cliente;
import com.chs.appbancoafv.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ClienteDAO  extends DAO<Cliente> {
    public static ClienteDAO instance;
    private static final String TABLE = "GUA_CLIENTES";
    private static final String KEY_CGCCPF = "CLI_CGCCPF";
    private static final String KEY_CODIGOCLIENTE = "CLI_CODIGOCLIENTE";
    private static final String KEY_RAZAOSOCIAL = "CLI_RAZAOSOCIAL";
    private static final String KEY_NOMEFANTASIA = "CLI_NOMEFANTASIA";
    private static final String KEY_TELEFONE = "CLI_TELEFONE";
    private static final String KEY_TELEFONE2 = "CLI_FAX";
    private static final String KEY_EMAIL = "CLI_EMAIL";
    private static final String KEY_EMAIL2 = "CLI_EMAILSECUNDARIO";
    private static final String KEY_ENDERECO = "CLI_ENDERECO";
    private static final String KEY_NUMERO = "CLI_NUMERO";
    private static final String KEY_COMPLEMENTO = "CLI_COMPLEMENTO";
    private static final String KEY_BAIRRO = "CLI_BAIRRO";
    private static final String KEY_CODMUNICIPIO = "CLI_CODIGOMUNICIPIO";


    public ClienteDAO() {

    }

    @Override
    public boolean saveOrEdit(Cliente cliente) {
        try {
            getWritableDB().insertWithOnConflict(TABLE,null,bindValues(cliente), SQLiteDatabase.CONFLICT_REPLACE);

        }catch (Exception e){
            Log.i ("INFOR", "Erro ao salvar o cliente" +e.getMessage());
        }
        return false;
    }

    @Override
    protected ContentValues bindValues(Cliente cliente){
        ContentValues contentValues = new ContentValues();

        contentValues.put(KEY_CODIGOCLIENTE, cliente.getCodigo());
        contentValues.put(KEY_CGCCPF, cliente.getCgccpf());
        contentValues.put(KEY_RAZAOSOCIAL, cliente.getRazao());
        contentValues.put(KEY_NOMEFANTASIA, cliente.getFantasia());
        contentValues.put(KEY_TELEFONE, cliente.getTelefone());
        contentValues.put(KEY_TELEFONE2, cliente.getFax());
        contentValues.put(KEY_EMAIL, cliente.getEmail());
        contentValues.put(KEY_EMAIL2, cliente.getEmailNf());
        contentValues.put(KEY_ENDERECO, cliente.getEndereco());
        contentValues.put(KEY_NUMERO, cliente.getNumero());
        contentValues.put(KEY_COMPLEMENTO, cliente.getComplemento());
        contentValues.put(KEY_BAIRRO, cliente.getBairro());
        contentValues.put(KEY_CODMUNICIPIO, cliente.getCodMunicipio());

        return  contentValues;
    }

    @Override
    protected Cliente bind(Cursor c) {
        Cliente cliente = new Cliente();

        cliente.setCodigo(getString(c, KEY_CODIGOCLIENTE));
        cliente.setCgccpf(getString(c, KEY_CGCCPF));
        cliente.setRazao(getString(c, KEY_RAZAOSOCIAL));
        cliente.setFantasia(getString(c, KEY_NOMEFANTASIA));
        cliente.setTelefone(getString(c, KEY_TELEFONE));
        cliente.setFax(getString(c, KEY_TELEFONE2));
        cliente.setEmail(getString(c, KEY_EMAIL));
        cliente.setEmailNf(getString(c, KEY_EMAIL2));
        cliente.setEndereco(getString(c, KEY_ENDERECO));
        cliente.setNumero(getString(c, KEY_NUMERO));
        cliente.setComplemento(getString(c, KEY_COMPLEMENTO));
        cliente.setBairro(getString(c, KEY_BAIRRO));
        cliente.setCodMunicipio(getString(c, KEY_CODMUNICIPIO));

        return cliente;
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
