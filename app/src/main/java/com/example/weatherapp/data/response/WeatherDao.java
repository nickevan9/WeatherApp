package com.example.weatherapp.data.response;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.weatherapp.data.model.WeatherEntity;

import java.util.List;

@Dao
public interface WeatherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Integer insertWeather(WeatherEntity weatherEntity);

    @Transaction
    @Query("SELECT * FROM weather")
    List<WeatherEntity> getAllWeather();

    @Delete
    Long deleteWeather(WeatherEntity weatherEntity);
}
