package com.example.weatherapp.data;

import com.example.weatherapp.data.model.air.AirEntity;
import com.example.weatherapp.data.model.weather.WeatherEntity;

public class WeatherAir {
    public WeatherAir(WeatherEntity weatherEntity, AirEntity airEntity) {
        this.weatherEntity = weatherEntity;
        this.airEntity = airEntity;
    }

    public WeatherEntity weatherEntity;
    public AirEntity airEntity;
}
