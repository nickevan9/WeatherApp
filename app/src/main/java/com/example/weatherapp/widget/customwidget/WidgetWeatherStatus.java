package com.example.weatherapp.widget.customwidget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.airbnb.lottie.LottieAnimationView;
import com.example.weatherapp.R;
import com.example.weatherapp.app.IconWeatherHelper;
import com.example.weatherapp.app.RxBus;
import com.example.weatherapp.app.TimeUtilsExt;
import com.example.weatherapp.data.model.DayEntity;
import com.example.weatherapp.data.model.weather.FcdEntity;
import com.example.weatherapp.data.model.weather.FchEntity;
import com.example.weatherapp.widget.CustomTextviewLight;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

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
    private ImageView imgStatusWeather;
    private String timeZone;
    private CustomTextviewLight tvDay;
    private CompositeDisposable disposable ;

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
        disposable = new CompositeDisposable();
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
        imgStatusWeather = findViewById(R.id.img_status_weather);
        tvDay = findViewById(R.id.tv_day);
        timeZone = "";
    }

    public void applyData(FchEntity fchEntity, FcdEntity fcdEntity, String timeZone) {
        tvTemp.setText(String.valueOf(fchEntity.getT().intValue()));
        tvWindChill.setText(getContext().getString(R.string.windchill, String.valueOf(fchEntity.getTf().intValue())));
        tvTempMax.setText(getContext().getString(R.string.set_temp, String.valueOf(fcdEntity.getTx().intValue())));
        tvTempMin.setText(getContext().getString(R.string.set_temp, String.valueOf(fcdEntity.getTn().intValue())));
        tvPressure.setText(getContext().getString(R.string.set_pressure, fchEntity.getP().toString()));
        setUVIndex(fchEntity.getUv());
        tvWeatherStatus.setText(fchEntity.getTxt());
        tvWindSpeed.setText(getContext().getString(R.string.set_wind_speed, fchEntity.getWs().toString()));

        tvHour.setText(TimeUtilsExt.convertTimeStampToLocalTime(fchEntity.getDt(), timeZone));

//        lottieWeather.setAnimation(IconWeatherHelper.getLottieWeather(fchEntity.getS()));

        imgStatusWeather.setBackgroundResource(IconWeatherHelper.getDrawableAnimationLarge(fchEntity.getS()));
        AnimationDrawable anim = (AnimationDrawable) imgStatusWeather.getBackground();
        anim.start();

        getTimeNow(timeZone);
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

    public void getTimeNow(String timeZone) {
        disposable.add(Observable.interval(1, TimeUnit.SECONDS).repeat().observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(aLong -> {
            DayEntity dayEntity = getTime(timeZone);
            tvHour.setText(dayEntity.getTime());
            tvDay.setText(dayEntity.getDayOfWeek());
        }));
    }

    private DayEntity getTime(String timeZone) {
        DateTimeZone.setDefault(DateTimeZone.forID(timeZone));
        DateTimeFormatter dateFormatTime = DateTimeFormat.forPattern("hh:mm aaa");
        DateTimeFormatter dateFormatDay = DateTimeFormat.forPattern("EEE");
        DateTime dateTimeNow = DateTime.now();
        DayEntity dayEntity = new DayEntity();

        dayEntity.setTime(dateFormatTime.print(dateTimeNow));
        dayEntity.setDayOfWeek(dateFormatDay.print(dateTimeNow));
        return dayEntity;

    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        RxBus.unregister(this);
        disposable.clear();
    }
}
