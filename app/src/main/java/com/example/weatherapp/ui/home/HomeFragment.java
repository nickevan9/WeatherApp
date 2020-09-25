package com.example.weatherapp.ui.home;


import androidx.lifecycle.ViewModelProviders;

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
        mViewModel = ViewModelProviders.of(this, viewModelFactory).get(HomeViewModel.class);
    }

    @Override
    protected void initView() {

    }

}