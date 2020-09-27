package com.example.weatherapp.ui.loadingdata;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.weatherapp.R;
import com.example.weatherapp.factory.ViewModelFactory;
import com.example.weatherapp.ui.base.BaseFragment;

import javax.inject.Inject;

public class LoadingDataFragment extends BaseFragment {

    private LoadingDataViewModel mViewModel;

    @Inject
    ViewModelFactory viewModelFactory;

    public static LoadingDataFragment newInstance() {
        return new LoadingDataFragment();
    }

    @Override
    protected int layoutRes() {
        return R.layout.fragment_loading_data;
    }

    @Override
    protected void dataCreate() {
        mViewModel = new ViewModelProvider(this,viewModelFactory).get(LoadingDataViewModel.class);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void fragmentBackPressed() {

    }




}