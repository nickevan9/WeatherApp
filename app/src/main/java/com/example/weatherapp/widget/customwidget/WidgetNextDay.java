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
import com.example.weatherapp.data.model.air.AirEntity;
import com.example.weatherapp.data.model.weather.FcdEntity;
import com.example.weatherapp.widget.customwidget.adapter.LinearLayoutPagerManager;
import com.example.weatherapp.widget.customwidget.adapter.NextDayAdapter;

import java.util.ArrayList;
import java.util.List;

public class WidgetNextDay extends RelativeLayout {
    private RelativeLayout rlNextDay;
    private TextView tvNextDay;
    protected RecyclerView rvNextDay;

    NextDayAdapter nextDayAdapter;

    private List<FcdEntity> fcdEntityList;
    private String timeZone;


    public WidgetNextDay(Context context) {
        super(context);
        initView();
    }

    public WidgetNextDay(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public WidgetNextDay(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }


    private void initView(){
        inflate(getContext(), R.layout.widget_next_day,this);

        fcdEntityList = new ArrayList<>();
        timeZone = "";

        nextDayAdapter = new NextDayAdapter(getContext(),fcdEntityList,timeZone);

        rlNextDay = findViewById(R.id.rl_next_day);
        tvNextDay = findViewById(R.id.tv_next_day);
        rvNextDay = findViewById(R.id.rv_next_day);

        LinearLayoutPagerManager layoutPagerManager = new LinearLayoutPagerManager(getContext(), LinearLayoutManager.HORIZONTAL, false,7);

        rvNextDay.setLayoutManager(layoutPagerManager);
        rvNextDay.setHasFixedSize(true);
        rvNextDay.setAdapter(nextDayAdapter);
        rvNextDay.setNestedScrollingEnabled(true);

    }

    public void applyData(List<FcdEntity> fcdEntityList,String timeZone){
        nextDayAdapter.applyData(fcdEntityList,timeZone);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        RxBus.subscribe(RxBus.TAG_TIME_ZONE,this,timeZoneObject ->{
            this.timeZone = (String)timeZoneObject;
        });

        RxBus.subscribe(RxBus.TAG_LIST_DAY_ITEM,this, listFcdObject ->{
            List<FcdEntity> fcdEntityList = (List<FcdEntity>) listFcdObject;
            if (!timeZone.equals("")){
                applyData(fcdEntityList,timeZone);
            }

        });
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        RxBus.unregister(this);
    }
}
