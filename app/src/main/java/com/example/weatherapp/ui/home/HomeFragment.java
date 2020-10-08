package com.example.weatherapp.ui.home;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import com.example.weatherapp.BuildConfig;
import com.example.weatherapp.R;
import com.example.weatherapp.app.FragmentUtils;
import com.example.weatherapp.app.RxBus;
import com.example.weatherapp.data.model.WeatherDb;
import com.example.weatherapp.listener.ItemClickListener;
import com.example.weatherapp.ui.adapter.HomeAdapter;
import com.example.weatherapp.ui.base.BaseFragment;
import com.example.weatherapp.ui.dialog.WeatherDialog;
import com.weather.placeautocomplete.autocomplete.ui.PlaceAutocompleteActivity;


import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;


public class HomeFragment extends BaseFragment implements ItemClickListener,HomeContract.View {


    private ViewPager2 vpHome;

    private HomeAdapter homeAdapter;

    private List<WeatherDb> weatherDbList;

    private List<WeatherDb> weatherDbs;



    @Inject
    public HomeContract.Controller homeController;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    protected int layoutRes() {
        return R.layout.fragment_home;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    private void transitionAddLocation(){

    }

    @Override
    protected void dataCreate() {

        homeController.attachView(this);

        weatherDbList = new ArrayList<>();

    }

    @Override
    protected void initView() {
        weatherDbList = new ArrayList<>();
        homeAdapter = new HomeAdapter(getContext(), weatherDbList, this);
        vpHome = requireView().findViewById(R.id.vPHome);
        vpHome.setAdapter(homeAdapter);

    }

    @Override
    public void onResume() {
        super.onResume();

        RxBus.subscribe(RxBus.TAG_ADD_LOCATION_CLICK, this, click -> {
//            transitionAddLocation();
//            startActivity(new Intent(requireActivity(), PlaceAutocompleteActivity.class));
            FragmentUtils.findNavController(this).navigate(R.id.action_homeFragment_to_placeAutocompleteFragment);
        });
                
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

    @Override
    public void showLoadingDB() {

    }

    @Override
    public void hideLoadingDB() {

    }

    @Override
    public void showLoadingAPI() {

    }

    @Override
    public void hideLoadingAPI() {

    }

    @Override
    public void loadDataSuccess(List<WeatherDb> weatherDbList) {
        weatherDbs = weatherDbList;
        homeAdapter.applyData(weatherDbList);
    }

    @Override
    public void loadDataFailed(String message) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        homeController.detachView(this);
        homeController.destroy();
    }
}