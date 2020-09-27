package com.example.weatherapp.di.modules;


import android.app.Application;

import androidx.room.Room;

import com.example.weatherapp.data.response.WeatherDao;
import com.example.weatherapp.data.room.WeatherDatabase;

import javax.inject.Singleton;

import dagger.Provides;

public abstract class DbModule {

    @Singleton
    @Provides
    public  final  WeatherDatabase provideDatabase(Application application) {
        return Room.databaseBuilder(
                application,
                WeatherDatabase.class,
                "weather.db"
        ).allowMainThreadQueries().fallbackToDestructiveMigration().build();
    }

    @Provides
    @Singleton
    public final WeatherDao provideWeatherDao(WeatherDatabase weatherDatabase){
        return weatherDatabase.weatherDao();
    }
}
