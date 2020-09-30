package com.example.weatherapp.listener;

import android.view.View;

public interface ItemClickListener {
    void onClickWeatherStatus(View view,int position);

    void onClickWeatherHour(View view,int position);

    void onClickWeatherDay(View view,int position);
}
