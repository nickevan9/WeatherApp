package com.example.weatherapp.di.modules;

import com.example.weatherapp.data.repository.WeatherRepository;
import com.example.weatherapp.ui.home.HomeContract;
import com.example.weatherapp.ui.home.HomeController;
import com.example.weatherapp.ui.loadingdata.LoadingContract;
import com.example.weatherapp.ui.loadingdata.LoadingController;

import dagger.Module;
import dagger.Provides;

@Module
public class PresenterModule {
    @Provides
    public LoadingContract.Controller providesLoadingPresenter(WeatherRepository weatherRepository) {
        return (LoadingContract.Controller) (new LoadingController(weatherRepository));
    }


    @Provides
    public HomeContract.Controller providesHomePresenter(WeatherRepository weatherRepository) {
        return (HomeContract.Controller) (new HomeController(weatherRepository));
    }

}
