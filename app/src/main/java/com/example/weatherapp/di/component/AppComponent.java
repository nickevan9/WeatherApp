package com.example.weatherapp.di.component;

import android.app.Application;

import com.example.weatherapp.WeatherApplication;
import com.example.weatherapp.di.modules.ActivityModule;
import com.example.weatherapp.di.modules.PresenterModule;
import com.example.weatherapp.di.modules.WeatherAppModule;
import com.example.weatherapp.di.modules.ContextModule;
import com.example.weatherapp.di.modules.DbModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import dagger.android.DaggerApplication;

@Singleton
@Component(modules = {
        ContextModule.class,
        WeatherAppModule.class,
        AndroidSupportInjectionModule.class,
        ActivityModule.class,
        DbModule.class,
        PresenterModule.class
})
public interface AppComponent extends AndroidInjector<DaggerApplication> {

    void inject(WeatherApplication application);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}