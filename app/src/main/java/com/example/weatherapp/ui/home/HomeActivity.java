package com.example.weatherapp.ui.home;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.viewpager2.widget.ViewPager2;

import com.example.weatherapp.R;
import com.example.weatherapp.app.ActivityUtils;
import com.example.weatherapp.app.RxBus;
import com.example.weatherapp.data.model.WeatherDb;
import com.example.weatherapp.listener.ItemClickListener;
import com.example.weatherapp.ui.adapter.HomeAdapter;
import com.example.weatherapp.ui.base.BaseActivity;
import com.example.weatherapp.ui.dialog.LoadingDialog;
import com.example.weatherapp.ui.dialog.WeatherDialog;
import com.example.weatherapp.ui.place.PlaceActivity;
import com.mapbox.geojson.Point;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Handler;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;


public class HomeActivity extends BaseActivity implements ItemClickListener, HomeContract.View {

    public static final int REQUEST_CODE_AUTOCOMPLETE = 100;

    private ViewPager2 vpHome;

    private HomeAdapter homeAdapter;

    private List<WeatherDb> weatherDbs;

    private LoadingDialog loadingDialog;

    ActivityResultLauncher<Intent> mStartForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent intent = result.getData();
                        Serializable dataPlace = intent.getSerializableExtra("dataPlace");
                        Double lat = ((Point) dataPlace).latitude();
                        Double lon = ((Point) dataPlace).longitude();
                        homeController.getSingleWeather(lat, lon);
                        // Handle the Intent
                    }
                }
            });


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
    protected void dataCreate() {
        loadingDialog = new LoadingDialog(this);
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

            Boolean state = (Boolean) click;
            if (state){
                Intent intent = new Intent(this, PlaceActivity.class);
//            registerForActivityResult(intent,REQUEST_CODE_AUTOCOMPLETE);

                mStartForResult.launch(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }

        });

        ActivityUtils.hideKeyboard(this);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_AUTOCOMPLETE) {
            if (resultCode == Activity.RESULT_OK) {
                assert data != null;
                Serializable result = data.getSerializableExtra("dataPlace");
                assert result != null;
                Double lat = ((Point) result).latitude();
                Double lon = ((Point) result).longitude();
                homeController.getSingleWeather(lat, lon);
            }
        }
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
        if (loadingDialog.getmDialog().isShowing()){
            loadingDialog.dismissDialog();
            loadingDialog.startLoading(1);
        }else {
            loadingDialog.startLoading(1);
        }
    }

    @Override
    public void hideLoading() {
        loadingDialog.dismissDialog();
    }

    @Override
    public void showLoadingAPI() {
        if (loadingDialog.getmDialog().isShowing()){
            loadingDialog.dismissDialog();
            loadingDialog.startLoading(0);
        }else {
            loadingDialog.startLoading(0);
        }
    }


    @SuppressLint("CheckResult")
    @Override
    public void loadDataSuccess(List<WeatherDb> weatherDbList, Boolean addWeather) {
        weatherDbs = weatherDbList;
        homeAdapter.applyData(weatherDbList);

        if (addWeather) {
            vpHome.setCurrentItem(weatherDbs.size(), false);
        }
        Observable
                .timer(1000, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(aLong -> loadingDialog.dismissDialog());

    }



    @Override
    public void loadDataFailed(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
        loadingDialog.dismissDialog();
    }



    @Override
    public void onDestroy() {
        super.onDestroy();
        homeController.detachView(this);
        homeController.destroy();
    }
}