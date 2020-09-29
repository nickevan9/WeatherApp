package com.example.weatherapp.widget.customwidget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.weatherapp.R;
import com.example.weatherapp.data.WeatherDb;

public class WidgetToolbar extends LinearLayout {
    private ImageView imgDropDown;
    private TextView tvLocation;
    private ImageView imgShare;
    private ImageView imgSetting;
    private ImageView imgAddLocation;
    public WidgetToolbar(Context context) {
        super(context);
        initView();
    }

    public WidgetToolbar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public WidgetToolbar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView(){
        inflate(getContext(), R.layout.widget_toolbar,this);
        imgDropDown = findViewById(R.id.img_drop_down);
        imgAddLocation = findViewById(R.id.img_location);
        imgSetting = findViewById(R.id.img_setting);
        imgShare = findViewById(R.id.img_share);
        tvLocation = findViewById(R.id.tv_name_city);
    }

    public void applyData(String name){
        tvLocation.setText(name);
    }
}
