package com.example.weatherapp.ui.dialog;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherapp.R;
import com.example.weatherapp.data.model.weather.WeatherEntity;

import java.util.List;

public class WeatherDialog {
    private Activity activity;
    private WeatherEntity weatherEntity;
    private ImageView imgClose;
    private TextView tvTime;
    private TextView tvTemp;
    private RecyclerView rvDetail;
    private DetailAdapter detailAdapter;
    private List<WeatherDetailEntity> detailEntityList;


    public WeatherDialog(Activity activity,WeatherEntity weatherEntity){
        this.activity = activity;
        this.weatherEntity = weatherEntity;

        View view = activity.getLayoutInflater().inflate(R.layout.dialog_weather,null);
        imgClose = view.findViewById(R.id.img_close);
        tvTime = view.findViewById(R.id.tv_time);
        tvTemp = view.findViewById(R.id.tv_temp);
        rvDetail = view.findViewById(R.id.rv_detail);

//        detailAdapter = new DetailAdapter()
        GridLayoutManager gridLayoutManager = new GridLayoutManager(activity,2);



    }



    private void initList(){
//        detailEntityList.add(new WeatherDetailEntity(1,"Pressure",R.drawable.ic_app,weatherEntity.));
    }
}
