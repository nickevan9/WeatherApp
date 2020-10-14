package com.example.weatherapp.widget.customwidget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherapp.R;

public class WidgetChangeSetting extends RelativeLayout {

    private Button btnWidget;
    private Button btnNotification;
    private Button btnIconSet;

    private TextView tvWidget;
    private TextView tvNotification;
    private TextView tvIconSet;

    private View viewWidget;
    private View viewNotification;
    private View viewIconSet;

    private RecyclerView rvChangeSetting;

    public WidgetChangeSetting(Context context) {
        super(context);
        initVieẉ();
    }

    public WidgetChangeSetting(Context context, AttributeSet attrs) {
        super(context, attrs);
        initVieẉ();
    }

    public WidgetChangeSetting(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initVieẉ();
    }

    private void initVieẉ() {
        inflate(getContext(), R.layout.widget_chang_setting, this);

        btnWidget = findViewById(R.id.btn_widget);
        btnNotification = findViewById(R.id.btn_notification);
        btnIconSet = findViewById(R.id.btn_icon_set);

        tvWidget = findViewById(R.id.tv_widget);
        tvNotification = findViewById(R.id.tv_notification);
        tvIconSet = findViewById(R.id.tv_icon_set);

        viewWidget = findViewById(R.id.view_widget);
        viewNotification = findViewById(R.id.view_notification);
        viewIconSet = findViewById(R.id.view_icon_widget);

        rvChangeSetting = findViewById(R.id.rv_change_setting);
    }
}
