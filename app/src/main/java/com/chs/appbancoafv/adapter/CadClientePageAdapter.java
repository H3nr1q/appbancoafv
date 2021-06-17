package com.chs.appbancoafv.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.chs.appbancoafv.view.CadastroClienteBasicoFragment;
import com.chs.appbancoafv.view.CadastroClienteEnderecosFragment;

public class CadClientePageAdapter extends FragmentStatePagerAdapter {
    private static final int NUM_PAGES = 4;

    public CadClientePageAdapter(FragmentManager fm) {
        super(fm);

    }


    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0 :
                return new CadastroClienteBasicoFragment();
            case 1:
                return new CadastroClienteEnderecosFragment();
            default:
                return null;

        }
    }

    @Override
    public int getCount() {
        return NUM_PAGES;

    }

    @Override
    public CharSequence getPageTitle(int position) {

        CharSequence title;
        switch (position){
            case 0: title = "DADOS";break;
            case 1: title = "ENDEREÇO";break;
            default:
                throw new IllegalStateException("Unexpected value: " + position);
        }
        return title;
    }
}
