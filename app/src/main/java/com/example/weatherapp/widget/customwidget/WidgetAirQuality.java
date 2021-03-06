package com.example.weatherapp.widget.customwidget;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.example.weatherapp.R;
import com.example.weatherapp.app.RxBus;
import com.example.weatherapp.data.model.air.AirEntity;

import at.grabner.circleprogress.CircleProgressView;

public class WidgetAirQuality extends RelativeLayout {
    private CircleProgressView circleAir;
    private TextView tvAirStatus;
    private TextView tvAirDetail;


    public WidgetAirQuality(Context context) {
        super(context);
        initVieẉ();
    }

    public WidgetAirQuality(Context context, AttributeSet attrs) {
        super(context, attrs);
        initVieẉ();
    }

    public WidgetAirQuality(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initVieẉ();
    }

    private void initVieẉ() {
        inflate(getContext(), R.layout.widget_air_quality, this);
        circleAir = findViewById(R.id.circle_air);
        tvAirStatus = findViewById(R.id.tv_air_status);
        tvAirDetail = findViewById(R.id.tv_air_detail);

    }

    public void applyData(AirEntity airEntity) {
        int airQuality = airEntity.getDataEntity().getAqi();
//        circleAir.setValue(airQuality);
        circleAir.setText(String.valueOf(airQuality));
        circleAir.setText(String.valueOf(airQuality));

        if (airQuality >= 300){
            tvAirStatus.setText(getContext().getString(R.string.heavy_pollution_title));
            tvAirDetail.setText(getContext().getString(R.string.heavy_pollution_description));
            circleAir.setTextColor(ContextCompat.getColor(getContext(),R.color.colorProgressFirst));
        }else if (airQuality >= 200){
            tvAirStatus.setText(getContext().getString(R.string.heavily_polluted_title));
            tvAirDetail.setText(getContext().getString(R.string.heavily_polluted_description));
            circleAir.setTextColor(ContextCompat.getColor(getContext(),R.color.colorProgressSecond));
        }else if (airQuality>= 150){
            tvAirStatus.setText(getContext().getString(R.string.moderate_pollution_title));
            tvAirDetail.setText(getContext().getString(R.string.moderate_pollution_description));
            circleAir.setTextColor(ContextCompat.getColor(getContext(),R.color.colorProgressThird));
        }else if (airQuality >= 100){
            tvAirStatus.setText(getContext().getString(R.string.slight_pollution_title));
            tvAirDetail.setText(getContext().getString(R.string.slight_pollution_description));
            circleAir.setTextColor(ContextCompat.getColor(getContext(),R.color.colorProgressFourth));
        }else if (airQuality >= 50){
            tvAirStatus.setText(getContext().getString(R.string.good_title));
            tvAirDetail.setText(getContext().getString(R.string.good_description));
            circleAir.setTextColor(ContextCompat.getColor(getContext(),R.color.colorProgressFifth));
        }else {
            tvAirStatus.setText(getContext().getString(R.string.excellent_title));
            tvAirDetail.setText(getContext().getString(R.string.excellent_description));
            circleAir.setTextColor(ContextCompat.getColor(getContext(),R.color.colorProgressSix));
        }
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        RxBus.subscribe(RxBus.TAG_AIR_WEATHER,this, airEntityObject ->{
            AirEntity airEntity = (AirEntity) airEntityObject;
            applyData(airEntity);
        });
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        RxBus.unregister(this);
    }
}
