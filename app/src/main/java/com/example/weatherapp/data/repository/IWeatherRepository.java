package com.example.weatherapp.data.repository;

import io.reactivex.disposables.Disposable;

public interface IWeatherRepository {
    Disposable getWeatherData(Double lat, Double lon) ;

    Disposable getAirData(Double lat, Double lon);
}
