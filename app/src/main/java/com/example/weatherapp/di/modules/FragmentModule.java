package com.example.weatherapp.di.modules;

import com.example.weatherapp.ui.detail.daydetail.DayDetailFragment;
import com.example.weatherapp.ui.detail.hourdetail.HourDetailFragment;
import com.example.weatherapp.ui.home.HomeFragment;
import com.example.weatherapp.ui.loadingdata.LoadingDataFragment;
import com.example.weatherapp.ui.location.LocationFragment;
import com.example.weatherapp.ui.setting.SettingFragment;
import com.example.weatherapp.ui.splash.SplashFragment;
import com.example.weatherapp.ui.walkthrough.WalkThroughFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentModule {
    @ContributesAndroidInjector
    abstract HomeFragment contributesHomeFragment();

    @ContributesAndroidInjector
    abstract DayDetailFragment contributesDayDetailFragment();

    @ContributesAndroidInjector
    abstract HourDetailFragment contributesHourDetailFragment();

    @ContributesAndroidInjector
    abstract LocationFragment contributesLocationFragment();

    @ContributesAndroidInjector
    abstract SettingFragment contributesSettingFragment();

    @ContributesAndroidInjector
    abstract SplashFragment contributesSplashFragment();

    @ContributesAndroidInjector
    abstract WalkThroughFragment contributesWalkThroughFragment();

    @ContributesAndroidInjector
    abstract LoadingDataFragment contributesLoadingDataFragment();
}
