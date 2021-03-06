package com.example.weatherapp.widget.customwidget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Pair;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherapp.R;
import com.example.weatherapp.app.RxBus;
import com.example.weatherapp.data.model.weather.FcdEntity;
import com.example.weatherapp.data.model.weather.FchEntity;
import com.example.weatherapp.widget.customwidget.adapter.NextHourAdapter;

import java.util.ArrayList;
import java.util.List;

public class WidgetNextHour extends RelativeLayout {

    private RelativeLayout rlNextHour;
    private TextView tvNextHour;
    private RecyclerView rvHour;
    private NextHourAdapter nextHourAdapter;

    private List<FchEntity> fchEntityList;
    private String timeZone;


    public WidgetNextHour(Context context) {
        super(context);
        initView();
    }

    public WidgetNextHour(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public WidgetNextHour(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }


    private void initView(){
        inflate(getContext(), R.layout.widget_next_hour,this);
        fchEntityList = new ArrayList<>();
        timeZone = "";

        nextHourAdapter = new NextHourAdapter(getContext(),fchEntityList,timeZone);

        rlNextHour = findViewById(R.id.rl_next_hour);
        tvNextHour = findViewById(R.id.tv_next_hour);
        rvHour = findViewById(R.id.rv_hour);

        LinearLayoutManager layoutPagerManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        rvHour.setLayoutManager(layoutPagerManager);
        rvHour.setHasFixedSize(true);
        rvHour.setAdapter(nextHourAdapter);
        rvHour.setNestedScrollingEnabled(true);
    }

    public void applyData(List<FchEntity> fchEntityList,String timeZone){
        nextHourAdapter.applyData(fchEntityList,timeZone);
        rvHour.setOnClickListener(view -> {

        });
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        RxBus.subscribe(RxBus.TAG_TIME_ZONE,this,timeZoneObject ->{
            this.timeZone = (String)timeZoneObject;
        });

        RxBus.subscribe(RxBus.TAG_LIST_HOUR_ITEM,this, listHourEntity ->{
            List<FchEntity> fchEntityList = (List<FchEntity>) listHourEntity;
            if (!timeZone.equals("")){
                applyData(fchEntityList,timeZone);
            }
        });
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        RxBus.unregister(this);
    }
}
