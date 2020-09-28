package com.example.weatherapp.ui.home;


import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import com.example.weatherapp.R;
import com.example.weatherapp.data.WeatherDb;
import com.example.weatherapp.factory.ViewModelFactory;
import com.example.weatherapp.ui.adapter.HomeAdapter;
import com.example.weatherapp.ui.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;


public class HomeFragment extends BaseFragment {

    private HomeViewModel mViewModel;

    private ViewPager2 vpHome;

    private HomeAdapter homeAdapter;

    private List<WeatherDb> weatherDbList;

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
        mViewModel = new ViewModelProvider(this, viewModelFactory).get(HomeViewModel.class);

        mViewModel.getListWeather().observe(getViewLifecycleOwner(),weatherDbList1 -> {
            homeAdapter.applyData(weatherDbList1);
        });
    }

    @Override
    protected void initView() {
        weatherDbList = new ArrayList<>();
        homeAdapter = new HomeAdapter(getContext(),weatherDbList);
        vpHome = requireView().findViewById(R.id.vPHome);
        vpHome.setAdapter(homeAdapter);

    }

    @Override
    protected void fragmentBackPressed() {
        requireActivity().finish();
    }


}