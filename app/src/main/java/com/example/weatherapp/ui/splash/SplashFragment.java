package com.example.weatherapp.ui.splash;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.weatherapp.R;
import com.example.weatherapp.app.DataProccessor;
import com.example.weatherapp.app.FragmentUtils;
import com.example.weatherapp.ui.base.BaseFragment;

public class SplashFragment extends BaseFragment {


    public static SplashFragment newInstance() {
        return new SplashFragment();
    }

    @Override
    protected int layoutRes() {
        return R.layout.fragment_splash;
    }

    @Override
    protected void dataCreate() {
        if (DataProccessor.getFirstTimeLaunch()){
            FragmentUtils.findNavController(this).navigate(R.id.action_splashFragment_to_walkThroughFragment);
        }else {
            FragmentUtils.findNavController(this).navigate(R.id.action_splashFragment_to_loadingDataFragment);
        }
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void fragmentBackPressed() {
        requireActivity().finish();
    }


}