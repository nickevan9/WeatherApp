package com.example.weatherapp;

import net.danlew.android.joda.JodaTimeAndroid;

import com.example.weatherapp.di.component.AppComponent;
import com.example.weatherapp.di.component.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;


public class WeatherApplication extends DaggerApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        JodaTimeAndroid.init(this);

    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        AppComponent component = DaggerAppComponent.builder().application(this).build();
        component.inject(this);
        return component;
    }
}
