package com.example.weatherapp.data.typeconvert;

import androidx.room.TypeConverter;

import com.example.weatherapp.data.model.weather.FchEntity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.List;


public class FchTypeConvert implements Serializable {

    @TypeConverter // note this annotation
    public String fromOptionValuesList(List<FchEntity> optionValues) {
        if (optionValues == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<FchEntity>>() {
        }.getType();
        String json = gson.toJson(optionValues, type);
        return json;
    }

    @TypeConverter // note this annotation
    public List<FchEntity> toOptionValuesList(String optionValuesString) {
        if (optionValuesString == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<FchEntity>>() {
        }.getType();
        List<FchEntity> fchEntities = gson.fromJson(optionValuesString, type);
        return fchEntities;
    }

}