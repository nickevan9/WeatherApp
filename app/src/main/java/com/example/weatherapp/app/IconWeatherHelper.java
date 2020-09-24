package com.example.weatherapp.app;

import android.content.Context;

import com.example.weatherapp.R;

public class IconWeatherHelper {

    public static int getIconWeather(String code, Context context) {
        String nameImage = code + ".png";
        int resId = context.getResources().getIdentifier(nameImage,"drawable",context.getPackageName());
        return resId;
    }

    public static int getLottieWeather(String code,Context context){

    }
}
