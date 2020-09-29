package com.example.weatherapp.widget.customwidget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherapp.R;
import com.example.weatherapp.data.model.FchEntity;
import com.example.weatherapp.widget.customwidget.adapter.LinearLayoutPagerManager;
import com.example.weatherapp.widget.customwidget.adapter.NextHourAdapter;

import java.util.ArrayList;
import java.util.List;

public class WidgetNextHour extends RelativeLayout {

    private RelativeLayout rlNextHour;
    private TextView tvNextHour;
    private RecyclerView rlHour;
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
        rlHour = findViewById(R.id.rv_hour);

        LinearLayoutPagerManager layoutPagerManager = new LinearLayoutPagerManager(getContext(), LinearLayoutManager.HORIZONTAL, false,7);
        rlHour.setLayoutManager(layoutPagerManager);
        rlHour.setHasFixedSize(true);
        rlHour.setAdapter(nextHourAdapter);
    }

    public void applyData(List<FchEntity> fchEntityList,String timeZone){
        nextHourAdapter.applyData(fchEntityList,timeZone);
        rlHour.setOnClickListener(view -> {

        });
    }


}
