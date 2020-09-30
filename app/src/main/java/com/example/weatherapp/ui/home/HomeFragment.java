package com.example.weatherapp.ui.home;


import android.view.View;

import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import com.example.weatherapp.R;
import com.example.weatherapp.data.WeatherDb;
import com.example.weatherapp.factory.ViewModelFactory;
import com.example.weatherapp.listener.ItemClickListener;
import com.example.weatherapp.ui.adapter.HomeAdapter;
import com.example.weatherapp.ui.base.BaseFragment;
import com.example.weatherapp.ui.dialog.WeatherDialog;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;


public class HomeFragment extends BaseFragment implements ItemClickListener {

    private HomeViewModel mViewModel;

    private ViewPager2 vpHome;

    private HomeAdapter homeAdapter;

    private List<WeatherDb> weatherDbList;

    private List<WeatherDb> weatherDbs;

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
        weatherDbList = new ArrayList<>();

        mViewModel = new ViewModelProvider(this, viewModelFactory).get(HomeViewModel.class);

        mViewModel.getListWeather().observe(getViewLifecycleOwner(), weatherDbList -> {
            weatherDbs = weatherDbList;
            homeAdapter.applyData(weatherDbList);
        });
    }

    @Override
    protected void initView() {
        weatherDbList = new ArrayList<>();
        homeAdapter = new HomeAdapter(getContext(), weatherDbList, this);
        vpHome = requireView().findViewById(R.id.vPHome);
        vpHome.setAdapter(homeAdapter);

    }

    @Override
    protected void fragmentBackPressed() {
        requireActivity().finish();
    }


    @Override
    public void onClickWeatherStatus(View view, int position) {
        new WeatherDialog(requireActivity(), weatherDbs.get(position).getWeatherEntity().getFch().get(0));
    }

    @Override
    public void onClickWeatherHour(View view, int position) {

    }

    @Override
    public void onClickWeatherDay(View view, int position) {

    }
}