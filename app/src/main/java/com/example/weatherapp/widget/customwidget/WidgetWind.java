package com.example.weatherapp.widget.customwidget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.weatherapp.R;
import com.example.weatherapp.data.model.FchEntity;

public class WidgetWind extends RelativeLayout {
    private TextView tvWindSpeed;
    private TextView tvWindChill;
    private TextView tvWindDirection;


    public WidgetWind(Context context) {
        super(context);
    }

    public WidgetWind(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public WidgetWind(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void initView(){
        inflate(getContext(), R.layout.widget_wind,this);
        tvWindSpeed = findViewById(R.id.tv_wind_speed);
        tvWindChill = findViewById(R.id.tv_wind_chill);
        tvWindDirection = findViewById(R.id.tv_wind_direction);
    }

    public void applyData(FchEntity fchEntity){
        tvWindSpeed.setText(getContext().getString(R.string.set_speed,fchEntity.getWs().toString()));
        tvWindChill.setText(getContext().getString(R.string.set_temp,fchEntity.getTf().toString()));
        tvWindDirection.setText(fchEntity.getWn());
    }
}
