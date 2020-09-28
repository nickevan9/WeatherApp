package com.example.weatherapp.data.response;

import android.util.Log;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.weatherapp.data.WeatherDb;

import java.util.List;

@Dao
public interface WeatherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Long insertWeather(WeatherDb weatherDb);

    @Transaction
    @Query("SELECT * FROM weather")
    List<WeatherDb> getAllWeather();

    @Delete
    void deleteWeather(WeatherDb weatherDb);
}
