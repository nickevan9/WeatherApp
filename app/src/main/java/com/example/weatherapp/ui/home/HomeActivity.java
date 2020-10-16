package com.example.weatherapp.ui.home;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.weatherapp.R;
import com.example.weatherapp.app.ActivityUtils;
import com.example.weatherapp.app.IconWeatherHelper;
import com.example.weatherapp.app.RxBus;
import com.example.weatherapp.app.TimeUtilsExt;
import com.example.weatherapp.data.model.WeatherDb;
import com.example.weatherapp.data.model.weather.FcdEntity;
import com.example.weatherapp.data.model.weather.FchEntity;
import com.example.weatherapp.data.model.weather.WeatherEntity;
import com.example.weatherapp.ui.adapter.HomePagerAdapter;
import com.example.weatherapp.ui.base.BaseActivity;
import com.example.weatherapp.ui.dialog.LoadingDialog;
import com.example.weatherapp.ui.place.PlaceActivity;
import com.example.weatherapp.widget.customwidget.WidgetAirQuality;
import com.example.weatherapp.widget.customwidget.WidgetNextDay;
import com.example.weatherapp.widget.customwidget.WidgetNextHour;
import com.example.weatherapp.widget.customwidget.WidgetPrecipitation;
import com.example.weatherapp.widget.customwidget.WidgetRainPercent;
import com.example.weatherapp.widget.customwidget.WidgetSunMoon;
import com.example.weatherapp.widget.customwidget.WidgetSunView;
import com.example.weatherapp.widget.customwidget.WidgetWind;
import com.google.android.material.appbar.AppBarLayout;
import com.mapbox.geojson.Point;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;


public class HomeActivity extends BaseActivity implements HomeContract.View {

    public static final int REQUEST_CODE_AUTOCOMPLETE = 100;

    private ViewPager2 vpHome;

//    private HomeAdapter homeAdapter;

    private List<WeatherDb> weatherDbs;

    private LoadingDialog loadingDialog;

    private HomePagerAdapter homePagerAdapter;

    private ImageView imgDropDown;
    private TextView tvLocation;
    private ImageView imgShare;
    private ImageView imgSetting;
    private ImageView imgAddLocation;
    private WidgetNextHour wgNextHour;
    private WidgetNextDay wgNextDay;
    private WidgetWind wgWind;
    private WidgetSunView wgSun;
    private WidgetSunMoon wgSunMoon;
    private WidgetAirQuality wgAir;
//    private WidgetRainPercent wgRain;
    private WidgetPrecipitation wgPrecipitation;
    private NestedScrollView scrollWeather;
    private CoordinatorLayout homeView;
    private AppBarLayout appBarLayout;
    private NestedScrollView scrollView;

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

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void initView() {

        homeView = findViewById(R.id.view_home);
        imgDropDown = findViewById(R.id.img_drop_down);
        imgAddLocation = findViewById(R.id.img_add_location);
        imgSetting = findViewById(R.id.img_setting);
        imgShare = findViewById(R.id.img_share);
        tvLocation = findViewById(R.id.tv_name_city);
        wgNextHour = findViewById(R.id.wg_next_hour);
        wgNextDay = findViewById(R.id.wg_next_day);
        wgWind = findViewById(R.id.wg_wind);
        wgAir = findViewById(R.id.wg_air);
        wgSun = findViewById(R.id.wg_sun);
        wgPrecipitation = findViewById(R.id.wg_precipitation);
        appBarLayout = findViewById(R.id.app_bar);
        scrollView = findViewById(R.id.scrollView);

        homePagerAdapter = new HomePagerAdapter(getSupportFragmentManager(), getLifecycle(), weatherDbs);
        vpHome = findViewById(R.id.vPHome);
        vpHome.setAdapter(homePagerAdapter);

        vpHome.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);

                WeatherDb weatherDb = weatherDbs.get(position);

                String timeZone = weatherDb.getWeatherEntity().getLoc().getTzname();

                Observable.fromArray(weatherDb).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).map(new Function<WeatherDb, WeatherDb>() {
                    @Override
                    public WeatherDb apply(WeatherDb weatherDb) throws Exception {
                        WeatherEntity weatherEntity = weatherDb.getWeatherEntity();

                        List<FchEntity> fchEntityList = TimeUtilsExt.mapTimeToNow(weatherDb.getWeatherEntity().getFch(), timeZone);
                        List<FcdEntity> fcdEntityList = TimeUtilsExt.mapDateToNow(weatherDb.getWeatherEntity().getFcd(), timeZone);

                        weatherEntity.setFcd(fcdEntityList);
                        weatherEntity.setFch(fchEntityList);

                        return weatherDb;
                    }
                }).subscribe(new Observer<WeatherDb>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(WeatherDb weatherDb) {
                        homeView.setBackgroundResource(IconWeatherHelper.getBackgroundWeather(weatherDb.getWeatherEntity().getFch().get(0).getS()));
                        tvLocation.setText(weatherDb.getCityName());

                        RxBus.publish(RxBus.TAG_TIME_ZONE, timeZone);
                        RxBus.publish(RxBus.TAG_AIR_WEATHER, weatherDb.getAirEntity());
                        RxBus.publish(RxBus.TAG_DAY_ITEM, weatherDb.getWeatherEntity().getFcd().get(0));
                        RxBus.publish(RxBus.TAG_LIST_DAY_ITEM, weatherDb.getWeatherEntity().getFcd());
                        RxBus.publish(RxBus.TAG_LIST_HOUR_ITEM, weatherDb.getWeatherEntity().getFch());
                        RxBus.publish(RxBus.TAG_HOUR_ITEM, weatherDb.getWeatherEntity().getFch().get(0));
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });



        imgAddLocation.setOnClickListener(view -> {
            Intent intent = new Intent(HomeActivity.this, PlaceActivity.class);
            mStartForResult.launch(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        });

        scrollView.setOnScrollChangeListener((NestedScrollView.OnScrollChangeListener) (v, scrollX, scrollY, oldScrollX, oldScrollY) -> {

            if (scrollY > oldScrollY) {
                appBarLayout.setBackgroundColor(ContextCompat.getColor(this,R.color.bg_tranfer_item));
            }
            if (scrollY < oldScrollY) {
                appBarLayout.setBackgroundColor(ContextCompat.getColor(this,R.color.bg_tranfer_item));
            }

            if (scrollY == 0) {
                appBarLayout.setBackgroundColor(Color.TRANSPARENT); // required to delete elevation shadow
            }
        });


    }

    @Override
    public void onResume() {
        super.onResume();
        ActivityUtils.hideKeyboard(this);

//        RxBus.subscribe(RxBus.TAG_CLICK_STATUS, this, state -> {
//            Boolean stateClick = (Boolean) state;
//            if (state){
//
//            }
//        });

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
    public void showLoadingDB() {
        if (loadingDialog.getmDialog().isShowing()) {
            loadingDialog.dismissDialog();
            loadingDialog.startLoading(1);
        } else {
            loadingDialog.startLoading(1);
        }
    }

    @Override
    public void hideLoading() {
        loadingDialog.dismissDialog();
    }

    @Override
    public void showLoadingAPI() {
        if (loadingDialog.getmDialog().isShowing()) {
            loadingDialog.dismissDialog();
            loadingDialog.startLoading(0);
        } else {
            loadingDialog.startLoading(0);
        }
    }



    @Override
    public void loadDataSuccess(List<WeatherDb> weatherDbList, Boolean addWeather) {
        weatherDbs = weatherDbList;
//        homeAdapter.applyData(weatherDbList);
        homePagerAdapter.applyData(weatherDbs);

        if (addWeather) {
            vpHome.setCurrentItem(weatherDbs.size(), false);
        }
        disposable.add(Observable
                .timer(1000, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(aLong -> loadingDialog.dismissDialog()));
    }


    @Override
    public void loadDataFailed(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        loadingDialog.dismissDialog();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        homeController.detachView(this);
        homeController.destroy();
    }
}