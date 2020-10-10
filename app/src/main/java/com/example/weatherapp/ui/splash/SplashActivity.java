package com.example.weatherapp.ui.splash;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.weatherapp.R;
import com.example.weatherapp.app.DataProccessor;
import com.example.weatherapp.ui.base.BaseActivity;
import com.example.weatherapp.ui.loadingdata.LoadingDataActivity;
import com.example.weatherapp.ui.walkthrough.WalkThroughActivity;

public class SplashActivity extends AppCompatActivity {

    private DataProccessor dataProccessor;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dataProccessor = new DataProccessor(this);
        if (dataProccessor.getFirstTimeLaunch()){
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

    public static SplashActivity newInstance() {
        return new SplashActivity();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}