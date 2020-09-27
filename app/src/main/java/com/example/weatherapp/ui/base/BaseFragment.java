package com.example.weatherapp.ui.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.weatherapp.app.DataProccessor;

import dagger.android.support.DaggerFragment;

public abstract class BaseFragment extends DaggerFragment
{

    public DataProccessor dataProccessor;
    @LayoutRes
    protected abstract int layoutRes();

    protected abstract void dataCreate();

    protected abstract void initView();

    protected abstract void fragmentBackPressed();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(layoutRes(),container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    @Override
    public void onResume() {
        super.onResume();
        dataProccessor = new DataProccessor(requireContext());
        dataCreate();

        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                fragmentBackPressed();
            }
        });
    }
}
