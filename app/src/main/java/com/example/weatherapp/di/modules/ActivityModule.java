package com.example.weatherapp.di.modules;

import com.example.weatherapp.ui.home.HomeActivity;
import com.example.weatherapp.ui.loadingdata.LoadingDataActivity;
import com.example.weatherapp.ui.splash.SplashActivity;
import com.example.weatherapp.ui.walkthrough.WalkThroughActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityModule {
    @ContributesAndroidInjector()
    abstract SplashActivity contributeSplashActivity();

    @ContributesAndroidInjector()
    abstract WalkThroughActivity contributeWalkThroughActivity();

    @ContributesAndroidInjector()
    abstract LoadingDataActivity contributeLoadingDataActivity();

    @ContributesAndroidInjector()
    abstract HomeActivity contributeHomeActivity();
}
