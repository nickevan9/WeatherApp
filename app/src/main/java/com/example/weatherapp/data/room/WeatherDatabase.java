package com.example.weatherapp.data.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.weatherapp.data.model.WeatherDb;
import com.example.weatherapp.data.response.WeatherDao;
import com.example.weatherapp.data.typeconvert.DateConvert;
import com.example.weatherapp.data.typeconvert.FcdTypeConvert;
import com.example.weatherapp.data.typeconvert.FchTypeConvert;


@Database(entities = {WeatherDb.class},version = 1)
@TypeConverters({FcdTypeConvert.class, FchTypeConvert.class, DateConvert.class})
public abstract class WeatherDatabase  extends RoomDatabase {
    public abstract WeatherDao weatherDao();

}
