package com.example.weatherapp.data;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.weatherapp.data.model.air.AirEntity;
import com.example.weatherapp.data.model.weather.WeatherEntity;

@Entity(
        tableName = "weather"
)
public class WeatherDb {
    @PrimaryKey
    private long locationId;

    private String cityName ;

    private Double latLocation ;

    private Double lonLocation;

    @Embedded
    private WeatherEntity weatherEntity;

    @Embedded
    private  AirEntity airEntity;

    public WeatherDb(long locationId, String cityName, Double latLocation, Double lonLocation, WeatherEntity weatherEntity,AirEntity airEntity) {
        this.locationId = locationId;
        this.cityName = cityName;
        this.latLocation = latLocation;
        this.lonLocation = lonLocation;
        this.weatherEntity = weatherEntity;
        this.airEntity = airEntity;
    }

    public WeatherDb() {

    }

    public long getLocationId() {
        return locationId;
    }

    public void setLocationId(long locationId) {
        this.locationId = locationId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Double getLatLocation() {
        return latLocation;
    }

    public void setLatLocation(Double latLocation) {
        this.latLocation = latLocation;
    }

    public Double getLonLocation() {
        return lonLocation;
    }

    public void setLonLocation(Double lonLocation) {
        this.lonLocation = lonLocation;
    }

    public WeatherEntity getWeatherEntity() {
        return weatherEntity;
    }

    public void setWeatherEntity(WeatherEntity weatherEntity) {
        this.weatherEntity = weatherEntity;
    }

    public AirEntity getAirEntity() {
        return airEntity;
    }

    public void setAirEntity(AirEntity airEntity) {
        this.airEntity = airEntity;
    }
}
