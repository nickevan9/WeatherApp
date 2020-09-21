package com.example.weatherapp.widget.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.airbnb.lottie.LottieAnimationView;
import com.example.weatherapp.R;
import com.example.weatherapp.widget.CustomTextviewLight;

public class WidgetWeatherStatus extends RelativeLayout {

    private CustomTextviewLight tvTemp;
    private CustomTextviewLight tvWindChill;
    private CustomTextviewLight tvTempMax;
    private CustomTextviewLight tvTempMin;
    private CustomTextviewLight tvPressure;
    private CustomTextviewLight tvUVIndex;
    private CustomTextviewLight tvWeatherStatus;
    private CustomTextviewLight tvWindSpeed;
    private CustomTextviewLight tvHour;
    private LottieAnimationView lottieWeather;

    public WidgetWeatherStatus(Context context) {
        super(context, null, android.R.attr.borderlessButtonStyle);
        initView();
    }

    public WidgetWeatherStatus(Context context, AttributeSet attrs) {
        super(context, attrs, android.R.attr.borderlessButtonStyle);
        initView();
    }

    public WidgetWeatherStatus(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, android.R.attr.borderlessButtonStyle);
        initView();
    }

    protected void initView(){
        inflate(getContext(), R.layout.widget_weather_status,this);
        tvTemp = findViewById(R.id.tv_temp);
        tvWindChill = findViewById(R.id.tv_wind_chill);
        tvTempMax = findViewById(R.id.tv_temp_max);
        tvTempMin = findViewById(R.id.tv_temp_min);
        tvPressure = findViewById(R.id.tv_pressure);
        tvUVIndex = findViewById(R.id.tv_uv_index);
        tvWeatherStatus = findViewById(R.id.tv_weather_status);
        tvWindSpeed = findViewById(R.id.tv_wind_speed);
        tvHour = findViewById(R.id.tv_hour);
        lottieWeather = findViewById(R.id.lottie_status_weather);
    }

    protected void applyData(){

    }
}
