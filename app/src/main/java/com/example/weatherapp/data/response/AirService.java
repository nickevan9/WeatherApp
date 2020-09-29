package com.example.weatherapp.data.response;

import com.example.weatherapp.data.model.air.AirEntity;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AirService {
    @GET("query.php")
    Single<AirEntity> getAirIndex(@Query("lat") Double lat, @Query("lng") Double lon);
}
