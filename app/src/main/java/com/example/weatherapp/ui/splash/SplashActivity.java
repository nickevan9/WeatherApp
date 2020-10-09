package com.example.weatherapp.ui.splash;

import android.content.Intent;

import com.example.weatherapp.R;
import com.example.weatherapp.app.DataProccessor;
import com.example.weatherapp.ui.base.BaseActivity;
import com.example.weatherapp.ui.loadingdata.LoadingDataActivity;
import com.example.weatherapp.ui.walkthrough.WalkThroughActivity;

public class SplashActivity extends BaseActivity {


    public static SplashActivity newInstance() {
        return new SplashActivity();
    }

    @Override
    protected int layoutRes() {
        return R.layout.fragment_splash;
    }

    @Override
    protected void dataCreate() {
        if (DataProccessor.getFirstTimeLaunch()){
            Intent intent = new Intent(this, WalkThroughActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            finish();

        }else {
            Intent intent = new Intent(this, LoadingDataActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            finish();
        }
    }

    @Override
    protected void initView() {

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}