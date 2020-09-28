package com.example.weatherapp.data.typeconvert;

import androidx.room.TypeConverter;

import com.example.weatherapp.data.model.FcdEntity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.List;

public class FcdTypeConvert implements Serializable {

    @TypeConverter // note this annotation
    public String fromOptionValuesList(List<FcdEntity> optionValues) {
        if (optionValues == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<FcdEntity>>() {
        }.getType();
        String json = gson.toJson(optionValues, type);
        return json;
    }

    @TypeConverter // note this annotation
    public List<FcdEntity> toOptionValuesList(String optionValuesString) {
        if (optionValuesString == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<FcdEntity>>() {
        }.getType();
        List<FcdEntity> fcdEntities = gson.fromJson(optionValuesString, type);
        return fcdEntities;
    }

}