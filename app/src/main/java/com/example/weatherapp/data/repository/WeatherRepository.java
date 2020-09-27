package com.example.weatherapp.data.repository;

import android.annotation.SuppressLint;

import com.example.weatherapp.data.model.WeatherEntity;
import com.example.weatherapp.data.response.WeatherDao;
import com.example.weatherapp.data.response.WeatherService;

import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.functions.Action;

@Singleton
public class WeatherRepository {
    private final WeatherService weatherService;
    private final WeatherDao weatherDao;

    @Inject
    public WeatherRepository(WeatherService weatherService, WeatherDao weatherDao) {
        this.weatherService = weatherService;
        this.weatherDao = weatherDao;
    }

    public Single<WeatherEntity> getWeatherData(Double lat, Double lon) {
        return weatherService.getWeatherData(lat, lon);
    }

    public Single<Integer> addWeather(WeatherEntity weatherEntity) {
        return Single.fromCallable((Callable) () -> weatherDao.insertWeather(weatherEntity));
    }

    public Single<List<WeatherEntity>> getAllWeatherFromDb(){
        return Single.fromCallable((Callable) () -> weatherDao.getAllWeather());
    }

    public Completable removeWeather(WeatherEntity weatherEntity){
        return Completable.fromAction((Action) () -> weatherDao.deleteWeather(weatherEntity));
    }
}
