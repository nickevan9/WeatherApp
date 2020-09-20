package com.example.weatherapp.data.response;

import com.example.weatherapp.data.model.WeatherEntity;

import javax.inject.Inject;

import io.reactivex.Single;

public class WeatherRepository {
    private final WeatherService weatherService;

    @Inject
    public WeatherRepository(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    public Single<WeatherEntity> getWeatherData(Double lat, Double lon) {
        return weatherService.getWeatherData(lat, lon);
    }
}
