package com.example.weatherapp.widget.customwidget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.airbnb.lottie.LottieAnimationView;
import com.example.weatherapp.R;
import com.example.weatherapp.app.IconWeatherHelper;
import com.example.weatherapp.app.TimeUtilsExt;
import com.example.weatherapp.data.model.FcdEntity;
import com.example.weatherapp.data.model.FchEntity;
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

    public void applyData(FchEntity fchEntity, FcdEntity fcdEntity, String timeZone) {
        tvTemp.setText(fchEntity.getT().toString());
        tvWindChill.setText(getContext().getString(R.string.windchill, fchEntity.getTf().toString()));
        tvTempMax.setText(getContext().getString(R.string.set_temp, fcdEntity.getTx().toString()));
        tvTempMin.setText(getContext().getString(R.string.set_temp, fcdEntity.getTn().toString()));
        tvPressure.setText(getContext().getString(R.string.set_pressure, fchEntity.getP().toString()));
        setUVIndex(fchEntity.getUv());
        tvWeatherStatus.setText(fchEntity.getTxt());
        tvWindSpeed.setText(getContext().getString(R.string.set_wind_speed, fchEntity.getWs().toString()));

        tvHour.setText(TimeUtilsExt.convertTimeStampToLocalTime(fchEntity.getDt(), timeZone));

        lottieWeather.setAnimation(IconWeatherHelper.getLottieWeather(fchEntity.getS()));
    }

    @SuppressLint("SetTextI18n")
    private void setUVIndex(double uvIndex) {
        if (uvIndex >= 1 && uvIndex < 3) {
            tvUVIndex.setText(uvIndex + getContext().getString(R.string.low));
        } else if (uvIndex >= 3 && uvIndex < 6) {
            tvUVIndex.setText(uvIndex + getContext().getString(R.string.moderate));
        } else if (uvIndex >= 6 && uvIndex < 8) {
            tvUVIndex.setText(uvIndex + getContext().getString(R.string.high));
        } else if (uvIndex >= 8 && uvIndex < 11) {
            tvUVIndex.setText(uvIndex + getContext().getString(R.string.very_high));
        } else {
            tvUVIndex.setText(uvIndex + getContext().getString(R.string.extreme));
        }
    }
}
