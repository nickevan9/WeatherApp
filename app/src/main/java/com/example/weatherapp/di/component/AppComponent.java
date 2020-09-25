package com.example.weatherapp.di.component;

import android.app.Application;

import com.example.weatherapp.WeatherApplication;
import com.example.weatherapp.di.modules.ActivityModule;
import com.example.weatherapp.di.modules.AdapterModule;
import com.example.weatherapp.di.modules.ApplicationModule;
import com.example.weatherapp.di.modules.ContextModule;
import com.example.weatherapp.di.modules.DbModule;
import com.example.weatherapp.di.modules.FragmentModule;
import com.example.weatherapp.di.modules.ViewModelModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import dagger.android.DaggerApplication;

@Singleton
@Component(modules = {
        ContextModule.class,
        ApplicationModule.class,
//        DbModule.class,
        AndroidSupportInjectionModule.class,
        ActivityModule.class,
//        AdapterModule.class,
        FragmentModule.class,
        ViewModelModule.class})
public interface AppComponent extends AndroidInjector<DaggerApplication> {

    void inject(WeatherApplication application);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}