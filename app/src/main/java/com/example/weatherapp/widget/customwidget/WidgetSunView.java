package com.example.weatherapp.widget.customwidget;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.weatherapp.R;
import com.example.weatherapp.app.TimeUtilsExt;
import com.example.weatherapp.data.model.FcdEntity;
import com.example.weatherapp.widget.customview.CircularSeekBar;

public class WidgetSunView extends LinearLayout implements Handler.Callback {
    private static final int REPEAT_ANIMATION_MSG = 2;

    private static final int TIME_DELAY_ANIMATION = 15;

    private boolean animationRunning = false;

    private int endProgress = 100;

    private boolean hadRunAnimation = false;

    private Handler handler;

    CircularSeekBar circularSeekBar;

    TextView tvMoonTitleNew;

    TextView tvSunrise;

    TextView tvSunset;

    TextView tvTitleSunMoon;

    public WidgetSunView(Context context) {
        super(context, null, android.R.attr.borderlessButtonStyle);
        initView();
    }

    public WidgetSunView(Context context, AttributeSet attrs) {
        super(context, attrs, android.R.attr.borderlessButtonStyle);
        initView();
    }

    public WidgetSunView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, android.R.attr.borderlessButtonStyle);
        initView();
    }

    private void initView(){
        inflate(getContext(), R.layout.widget_sun_view,this);
        circularSeekBar = findViewById(R.id.circularSeekBar);
        tvMoonTitleNew = findViewById(R.id.tv_moon_title_new);
        tvSunrise = findViewById(R.id.tv_sunrise_address);
        tvSunset = findViewById(R.id.tv_sunset_address);
    }

    public void applyData(FcdEntity fcdEntity, String timeZone){
        circularSeekBar.setMax(100);
        tvSunrise.setText(fcdEntity.getRise());
        tvSunset.setText(fcdEntity.getSet());
        long timeNow = TimeUtilsExt.formatTimeNow(timeZone);
        long timeStart = TimeUtilsExt.formatStringToTime(fcdEntity.getRise(),timeZone);
        long timeEnd = TimeUtilsExt.formatStringToTime(fcdEntity.getSet(),timeZone);
        endProgress = TimeUtilsExt.endTimeProgress(timeNow,timeStart,timeEnd);

        
    }

    public boolean isHadRunAnimation() {
        return !this.animationRunning;
    }


    @Override
    public boolean handleMessage(@NonNull Message message) {
        if (message.what == 2) {
            int start = message.getData().getInt("start");
            int end = message.getData().getInt("end");
            if (start < end)
                runProgress(start + 1);
            if (start == end) {
                this.hadRunAnimation = true;
                this.animationRunning = false;
            }
            this.circularSeekBar.setProgress(start);
        }
        return false;
    }



    public void removeAllMessages() {
        Handler handler = this.handler;
        if (handler != null)
            handler.removeMessages(2);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeAllMessages();
    }

    public void runProgress(int paramInt) {
        if (this.hadRunAnimation) {
            this.circularSeekBar.setProgress(this.endProgress);
            return;
        }
        if (this.handler == null)
            this.handler = new Handler(this);
        this.animationRunning = true;
        Bundle bundle = new Bundle();
        bundle.putInt("start", paramInt);
        bundle.putInt("end", this.endProgress);
        Message message = new Message();
        message.what = 2;
        message.setData(bundle);
        this.handler.sendMessageDelayed(message, 15L);
    }
}
