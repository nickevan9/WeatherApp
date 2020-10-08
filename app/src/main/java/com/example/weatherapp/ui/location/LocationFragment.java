package com.example.weatherapp.ui.location;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentTransaction;

import com.example.weatherapp.BuildConfig;
import com.example.weatherapp.R;
import com.example.weatherapp.app.FragmentUtils;
import com.example.weatherapp.ui.base.BaseFragment;


import javax.inject.Inject;

public class LocationFragment extends BaseFragment implements LocationContract.View {




    public static LocationFragment newInstance() {
        return new LocationFragment();
    }

    @Inject
    public LocationContract.Controller locationController;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
        }
    }

    @Override
    protected int layoutRes() {
        return R.layout.fragment_location;
    }

    @Override
    protected void dataCreate() {
        locationController.attachView(this);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void fragmentBackPressed() {

    }


    @Override
    public void onDetach() {
        super.onDetach();

    }


    @Override
    public void insertDataSuccess() {

    }

    @Override
    public void loadDataFailed(String message) {

    }

    @Override
    public void showLoadingDB() {

    }

    @Override
    public void hideLoadingDB() {

//        FragmentUtils.findNavController(this).popBackStack();
    }

    @Override
    public void showLoadingAPI() {

    }

    @Override
    public void hideLoadingAPI() {

    }


}