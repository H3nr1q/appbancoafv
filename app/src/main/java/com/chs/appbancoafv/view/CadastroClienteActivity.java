package com.chs.appbancoafv.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;


import com.chs.appbancoafv.R;
import com.chs.appbancoafv.adapter.CadClientePageAdapter;
import com.chs.appbancoafv.model.Cliente;
import com.chs.appbancoafv.presenter.CadastrarClientePresenter;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

public class CadastroClienteActivity extends AppCompatActivity implements ICadastroCliente {
    AppBarLayout appBarLayout;
    Toolbar toolbar;
    ViewPager viewPager;
    CadClientePageAdapter pageAdapter;
    TabLayout tabLayout;
    static final String EXTRA_CLIENTE = "cliente";
    String tipoPessoa, cgccpf;
    private Cliente cliente;
    private CadastrarClientePresenter cadastrarClientePresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_cliente);
        cliente = new Cliente();
        bindViews();

        Intent intent = getIntent();
        tipoPessoa = intent.getStringExtra("tipoPessoa");
        cgccpf = intent.getStringExtra("cgccpf");
        toolbar.setTitle("Novo cliente - " + cgccpf);
        cadastrarClientePresenter = new CadastrarClientePresenter();

        if(cliente.getCodigo() == null){
            cliente.setCodigo(cliente.generateId());
        }


    }

    private void bindViews() {
        appBarLayout = findViewById(R.id.appBarLayout);
        toolbar = findViewById(R.id.toolbarCliente);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        viewPager = findViewById(R.id.container);
        tabLayout = findViewById(R.id.tabCadClientes);
        tabLayout.setupWithViewPager(viewPager);
        pageAdapter = new CadClientePageAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pageAdapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                isCurrentClienteValido(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_salvar, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.optionSalvar:
                if(isClienteValido()){
                    salvarCliente();
                }
        }


        return super.onOptionsItemSelected(item);
    }

    private void salvarCliente() {
        if(cliente != null){
          cadastrarClientePresenter.salvarEditarCliente(cliente);

        }else{
            Toast.makeText(this, "Erro ao salvar Cliente", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public Cliente getCliente() {
        return cliente;
    }

    public boolean isCurrentClienteValido(int position) {
        if (position > 0) {
            for (int i = 0; i < position; i++) {
                Fragment fragment = getPage(i);
                if (fragment instanceof CadastroClienteFragment) {
                    if (!((CadastroClienteFragment) fragment).isValid()) {
                        viewPager.setCurrentItem(i);
                        return false;
                    }
                }
            }
        } else {
            Fragment fragment = getPage(viewPager.getCurrentItem());

            if (fragment instanceof CadastroClienteFragment) {

                if (!((CadastroClienteFragment) fragment).isValid()){
                    viewPager.setCurrentItem(viewPager.getCurrentItem());
                }
                return false;
            }
        }
        return true;
    }

    public boolean isClienteValido(){

        for(int position = 0; position < pageAdapter.getCount(); position++ ){
            Fragment fragment = getPage(position);
            if(fragment instanceof CadastroClienteFragment){
                if(!((CadastroClienteFragment)fragment).isValid()){
                    viewPager.setCurrentItem(position);
                    return false;
                }
            }
        }
        return true;
    }



    public Fragment getPage(int position){
        return (Fragment) pageAdapter.instantiateItem(viewPager, position);
    }

}