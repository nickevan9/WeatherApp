package com.example.weatherapp.widget.customwidget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.weatherapp.R;
import com.example.weatherapp.app.RxBus;
import com.example.weatherapp.app.WindConvert;
import com.example.weatherapp.data.model.weather.FchEntity;

public class WidgetWind extends RelativeLayout {
    private TextView tvWindSpeed;
    private TextView tvWindChill;
    private TextView tvWindDirection;
    private ImageView imgWind;
    private TextView tvWindDetail;
    private ImageView imgDirection;


    private double windSpeed = 1.0D;


    public WidgetWind(Context context) {
        super(context);
        initView();
    }

    public WidgetWind(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public WidgetWind(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        inflate(getContext(), R.layout.widget_wind, this);
        tvWindSpeed = findViewById(R.id.tv_wind_speed);
        tvWindChill = findViewById(R.id.tv_wind_chill);
        tvWindDirection = findViewById(R.id.tv_wind_direction);
        imgWind = findViewById(R.id.img_wind);
        tvWindDetail = findViewById(R.id.tv_wind_detail);
        imgDirection = findViewById(R.id.img_direction);

    }

    public void applyData(FchEntity fchEntity) {
        tvWindSpeed.setText(getContext().getString(R.string.set_speed, fchEntity.getWs().toString()));
        tvWindChill.setText(getContext().getString(R.string.set_temp, fchEntity.getTf().toString()));
        tvWindDirection.setText(fchEntity.getWn());
        windSpeed = fchEntity.getWs();
        tvWindDetail.setText(WindConvert.convertWindDirection(fchEntity.getWn()));
        imgDirection.setRotation(WindConvert.rotateImage(fchEntity.getWn()));

        rotateWindSpeed();
    }


    private void rotateWindSpeed() {
        if (windSpeed <= 0.0D)
            windSpeed = 1.0D;
        double d1 = 10000;
        double d2 = windSpeed;
        Double.isNaN(d1);
        long duration = (long) (d1 / d2);
        RotateAnimation rotateAnimation = new RotateAnimation(0, 360,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setDuration(duration);
        rotateAnimation.setRepeatCount(Animation.INFINITE);
        rotateAnimation.setInterpolator((Interpolator) new LinearInterpolator());
        imgWind.startAnimation((Animation) rotateAnimation);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        RxBus.subscribe(RxBus.TAG_HOUR_ITEM, this, fchObject -> {
            FchEntity fchEntity = (FchEntity) fchObject;
            applyData(fchEntity);

        });
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        RxBus.unregister(this);
    }
}
