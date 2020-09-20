package com.example.weatherapp.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;

import com.example.weatherapp.R;
import com.example.weatherapp.ui.base.BaseActivity;

public class MainActivity extends BaseActivity {

    private NavController navController;

    @Override
    protected int layoutRes() {
        return R.layout.activity_main;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            setupNavController();
        }
    }

    @Override
    protected void initView() {


    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        setupNavController();
    }

    private void setupNavController(){
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_container);
        navController = navHostFragment.getNavController();
    }

    @Override
    protected void dataReceive() {

    }


}