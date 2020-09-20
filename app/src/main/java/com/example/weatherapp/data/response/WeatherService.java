package com.example.weatherapp.data.response;

import com.example.weatherapp.data.model.WeatherEntity;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherService {
    @GET("current.php")
    Single<WeatherEntity> getWeatherData(@Query("lat") Double lat, @Query("lon") Double lon);
}
