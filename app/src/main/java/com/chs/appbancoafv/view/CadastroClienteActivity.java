package com.chs.appbancoafv.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.Toast;


import com.chs.appbancoafv.R;
import com.chs.appbancoafv.adapter.CadClientePageAdapter;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

public class CadastroClienteActivity extends AppCompatActivity {
    AppBarLayout appBarLayout;
    Toolbar toolbar;
    ViewPager viewPager;
    CadClientePageAdapter pageAdapter;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_cliente);
        bindViews();


    }

    private void bindViews(){
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
    }

}