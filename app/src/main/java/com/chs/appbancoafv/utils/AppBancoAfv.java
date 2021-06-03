package com.chs.appbancoafv.utils;

import androidx.multidex.MultiDexApplication;

public class AppBancoAfv extends MultiDexApplication {
    private static AppBancoAfv instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
    public static AppBancoAfv getInstance(){
        return instance;
    }
}
