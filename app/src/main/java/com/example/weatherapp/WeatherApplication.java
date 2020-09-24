package com.example.weatherapp;

import android.app.Application;

import net.danlew.android.joda.JodaTimeAndroid;

public class WeatherApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        JodaTimeAndroid.init(this);

        DaggerAppComponent.builder()
                .application(this)
                .build()
                .inject(this);
    }
}
