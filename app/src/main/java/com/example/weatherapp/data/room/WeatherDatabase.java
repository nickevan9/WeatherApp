package com.example.weatherapp.data.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.weatherapp.data.model.WeatherEntity;
import com.example.weatherapp.data.response.WeatherDao;

@Database(entities = WeatherEntity.class,version = 1)

public abstract class WeatherDatabase  extends RoomDatabase {
    public abstract WeatherDao weatherDao();
}
