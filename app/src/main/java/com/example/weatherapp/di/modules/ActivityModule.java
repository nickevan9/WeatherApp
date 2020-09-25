package com.example.weatherapp.di.modules;

import com.example.weatherapp.ui.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityModule {
    @ContributesAndroidInjector()
    abstract MainActivity contributeMainActivity();
}
