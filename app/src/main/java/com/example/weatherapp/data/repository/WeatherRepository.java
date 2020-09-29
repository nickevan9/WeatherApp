package com.example.weatherapp.data.repository;

import com.example.weatherapp.data.WeatherDb;
import com.example.weatherapp.data.model.air.AirEntity;
import com.example.weatherapp.data.model.weather.WeatherEntity;
import com.example.weatherapp.data.response.AirService;
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
    private final AirService airService;

    @Inject
    public WeatherRepository(WeatherService weatherService, WeatherDao weatherDao,AirService airService) {
        this.weatherService = weatherService;
        this.weatherDao = weatherDao;
        this.airService = airService;
    }

    public Single<WeatherEntity> getWeatherData(Double lat, Double lon) {
        return weatherService.getWeatherData(lat, lon);
    }

    public Single<AirEntity> getAirData(Double lat, Double lon) {
        return airService.getAirIndex(lat, lon);
    }

    public Single<Long> addWeather(WeatherDb weatherDb) {
        return Single.fromCallable((Callable) () -> weatherDao.insertWeather(weatherDb));
    }

    public Single<List<WeatherDb>> getAllWeatherFromDb(){
        return Single.fromCallable((Callable) () -> weatherDao.getAllWeather());
    }

    public Completable removeWeather(WeatherDb weatherDb){
        return Completable.fromAction((Action) () -> weatherDao.deleteWeather(weatherDb));
    }
}
