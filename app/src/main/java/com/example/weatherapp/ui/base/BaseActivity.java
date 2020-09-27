package com.example.weatherapp.ui.base;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;

import dagger.android.support.DaggerAppCompatActivity;

public abstract class BaseActivity  extends DaggerAppCompatActivity {


    protected abstract void initView();

    protected abstract void dataReceive();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
   ;

        initView();
    }

    @Override
    protected void onResume() {
        super.onResume();

        dataReceive();
    }
}
