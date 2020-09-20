package com.example.weatherapp.ui.home;

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

public class HomeFragment extends BaseFragment {

    private HomeViewModel mViewModel;

    @Inject
    ViewModelFactory viewModelFactory;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    protected int layoutRes() {
        return R.layout.fragment_home;
    }

    @Override
    protected void dataCreate() {

    }

    @Override
    protected void initView() {

    }

}