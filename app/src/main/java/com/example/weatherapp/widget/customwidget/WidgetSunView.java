package com.example.weatherapp.widget.customwidget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;


import com.example.weatherapp.R;
import com.example.weatherapp.app.TimeUtilsExt;
import com.example.weatherapp.data.model.weather.FcdEntity;
import com.example.weatherapp.widget.customview.SunInDayCustom;

public class WidgetSunView extends RelativeLayout {
    private SunInDayCustom sunInDayCustom;

    public WidgetSunView(Context context) {
        super(context);
        initView();
    }

    public WidgetSunView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public WidgetSunView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView(){
        inflate(getContext(), R.layout.widget_sun_view,this);
        sunInDayCustom = findViewById(R.id.sun_in_day);

    }


    public void applyData(FcdEntity fcdEntity, String timeZone){
        String timeNow = TimeUtilsExt.formatTimeNowHour(timeZone);
        sunInDayCustom.updateTime(fcdEntity.getRise(),fcdEntity.getSet(),timeNow);
//        circularSeekBar.setMax(100);
//        tvSunrise.setText(fcdEntity.getRise());
//        tvSunset.setText(fcdEntity.getSet());
//        long timeNow = TimeUtilsExt.formatTimeNow(timeZone);
//        long timeStart = TimeUtilsExt.formatStringToTime(fcdEntity.getRise(),timeZone);
//        long timeEnd = TimeUtilsExt.formatStringToTime(fcdEntity.getSet(),timeZone);
//        endProgress = TimeUtilsExt.endTimeProgress(timeNow,timeStart,timeEnd);


    }
}
