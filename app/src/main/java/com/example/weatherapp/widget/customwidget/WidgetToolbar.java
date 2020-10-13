package com.example.weatherapp.widget.customwidget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.weatherapp.R;
import com.example.weatherapp.app.RxBus;

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
        imgAddLocation = findViewById(R.id.img_add_location);
        imgSetting = findViewById(R.id.img_setting);
        imgShare = findViewById(R.id.img_share);
        tvLocation = findViewById(R.id.tv_name_city);

        imgAddLocation.setOnClickListener(view -> {
            RxBus.publish(RxBus.TAG_ADD_LOCATION_CLICK, true);
        });
    }

    public void applyData(String name) {
        tvLocation.setText(name);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        RxBus.subscribe(RxBus.TAG_NAME_LOCATION, this, nameLocation -> {
            String name = (String) nameLocation;
            applyData(name);
        });
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        RxBus.unregister(this);
    }
}
