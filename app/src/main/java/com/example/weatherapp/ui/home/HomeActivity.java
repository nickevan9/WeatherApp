package com.example.weatherapp.ui.home;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.viewpager2.widget.ViewPager2;

import com.example.weatherapp.R;
import com.example.weatherapp.app.RxBus;
import com.example.weatherapp.data.model.WeatherDb;
import com.example.weatherapp.listener.ItemClickListener;
import com.example.weatherapp.ui.adapter.HomeAdapter;
import com.example.weatherapp.ui.base.BaseActivity;
import com.example.weatherapp.ui.dialog.WeatherDialog;
import com.example.weatherapp.ui.place.PlaceActivity;


import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;


public class HomeActivity extends BaseActivity implements ItemClickListener,HomeContract.View {


    private ViewPager2 vpHome;

    private HomeAdapter homeAdapter;

    private List<WeatherDb> weatherDbs;

    @Inject
    public HomeContract.Controller homeController;

    public static HomeActivity newInstance() {
        return new HomeActivity();
    }

    @Override
    protected int layoutRes() {
        return R.layout.activity_home;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


    @Override
    protected void dataCreate() {

        homeController.attachView(this);

        weatherDbs = new ArrayList<>();

    }

    @Override
    protected void initView() {
        homeAdapter = new HomeAdapter(this, weatherDbs, this);
        vpHome = findViewById(R.id.vPHome);
        vpHome.setAdapter(homeAdapter);

    }

    @Override
    public void onResume() {
        super.onResume();

        RxBus.subscribe(RxBus.TAG_ADD_LOCATION_CLICK, this, click -> {
            Intent intent = new Intent(this, PlaceActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        });
                
    }



    @Override
    public void onClickWeatherStatus(View view, int position) {
        new WeatherDialog(this, weatherDbs.get(position).getWeatherEntity().getFch().get(0));
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