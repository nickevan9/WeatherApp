package com.example.weatherapp.widget.customwidget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.weatherapp.R;
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
        circleAir.setValue(airQuality);
        circleAir.setText(String.valueOf(airQuality));

        if (airQuality >= 300){
            tvAirStatus.setText(getContext().getString(R.string.heavy_pollution_title));
            tvAirDetail.setText(getContext().getString(R.string.heavy_pollution_description));
        }else if (airQuality >= 200){
            tvAirStatus.setText(getContext().getString(R.string.heavily_polluted_title));
            tvAirDetail.setText(getContext().getString(R.string.heavily_polluted_description));
        }else if (airQuality>= 150){
            tvAirStatus.setText(getContext().getString(R.string.moderate_pollution_title));
            tvAirDetail.setText(getContext().getString(R.string.moderate_pollution_description));
        }else if (airQuality >= 100){
            tvAirStatus.setText(getContext().getString(R.string.slight_pollution_title));
            tvAirDetail.setText(getContext().getString(R.string.slight_pollution_description));
        }else if (airQuality >= 50){
            tvAirStatus.setText(getContext().getString(R.string.good_title));
            tvAirDetail.setText(getContext().getString(R.string.good_description));
        }else {
            tvAirStatus.setText(getContext().getString(R.string.excellent_title));
            tvAirDetail.setText(getContext().getString(R.string.excellent_description));
        }
    }
}
