package com.example.weatherapp.ui.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherapp.R;
import com.example.weatherapp.app.TimeUtilsExt;
import com.example.weatherapp.data.model.weather.FcdEntity;
import com.example.weatherapp.data.model.weather.FchEntity;
import com.example.weatherapp.data.model.weather.WeatherEntity;

import java.util.ArrayList;
import java.util.List;

public class WeatherDialog {
    private Activity activity;
    private FchEntity fchEntity;
    private ImageView imgClose;
    private TextView tvTime;
    private TextView tvTemp;
    private RecyclerView rvDetail;
    private DetailAdapter detailAdapter;
    private List<WeatherDetailEntity> detailEntityList;
    private AlertDialog mDialog;
    private String timeZone;


    public WeatherDialog(Activity activity,FchEntity fchEntity,String timeZone){
        this.activity = activity;
        this.fchEntity = fchEntity;


        View view = activity.getLayoutInflater().inflate(R.layout.dialog_weather,null);

        initList();

        imgClose = view.findViewById(R.id.img_close);
        tvTime = view.findViewById(R.id.tv_time);
        tvTemp = view.findViewById(R.id.tv_temp);
        rvDetail = view.findViewById(R.id.rv_detail);

        detailAdapter = new DetailAdapter(activity,detailEntityList);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(activity,2);
        rvDetail.setLayoutManager(gridLayoutManager);
        rvDetail.setHasFixedSize(true);
        rvDetail.setAdapter(detailAdapter);

        tvTime.setText(TimeUtilsExt.convertTimeStampToLocalTime2(fchEntity.getDt(), timeZone));
        tvTemp.setText(activity.getString(R.string.set_temp, fchEntity.getTf().toString()));


        imgClose.setOnClickListener(view1 -> mDialog.dismiss());

        mDialog = new AlertDialog.Builder(activity).create();
        mDialog.setView(view);
        mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        mDialog.setCanceledOnTouchOutside(true);
        mDialog.show();



    }



    private void initList(){
        detailEntityList = new ArrayList<>();
        double uv = fchEntity.getUv();
        detailEntityList.add(new WeatherDetailEntity(1,"Rain percent",R.drawable.ic_details_dewpoint_svg,fchEntity.getPp() + " %"));

        detailEntityList.add(new WeatherDetailEntity(1,"Wind chill",R.drawable.ic_details_willchill_svg,fchEntity.getTf() + " °C"));

        detailEntityList.add(new WeatherDetailEntity(1,"Pressure",R.drawable.ic_details_pressure_svg,fchEntity.getP() + " mmHg"));

        detailEntityList.add(new WeatherDetailEntity(1,"Visibility",R.drawable.ic_details_visibility,fchEntity.getV() + " km"));

        detailEntityList.add(new WeatherDetailEntity(1,"Humidity",R.drawable.ic_details_humidity_svg,fchEntity.getRh() + " %"));

        if (uv > 11.0 ){
            detailEntityList.add(new WeatherDetailEntity(1,"UV index",R.drawable.ic_details_uvsun_svg,fchEntity.getUv() + " (Extreme)"));
        }else if (uv > 8.0){
            detailEntityList.add(new WeatherDetailEntity(1,"UV index",R.drawable.ic_details_uvsun_svg,fchEntity.getUv() + " (Very high)"));
        }else if (uv > 6.0){
            detailEntityList.add(new WeatherDetailEntity(1,"UV index",R.drawable.ic_details_uvsun_svg,fchEntity.getUv() + " (High)"));
        }else if (uv > 3.0){
            detailEntityList.add(new WeatherDetailEntity(1,"UV index",R.drawable.ic_details_uvsun_svg,fchEntity.getUv() + " (Moderate)"));
        }else{
            detailEntityList.add(new WeatherDetailEntity(1,"UV index",R.drawable.ic_details_uvsun_svg,fchEntity.getUv() + " (Low)"));
        }


        detailEntityList.add(new WeatherDetailEntity(1,"Wind speed",R.drawable.ic_details_windspeed_svg,fchEntity.getWs()+ " mph"));

        detailEntityList.add(new WeatherDetailEntity(1,"Wind direction",R.drawable.ic_details_wind_direction_svg,fchEntity.getWn()));

        detailEntityList.add(new WeatherDetailEntity(1,"Precipitation",R.drawable.ic_details_precipitation_svg,fchEntity.getPr() + " in"));

        detailEntityList.add(new WeatherDetailEntity(1,"Cloud cover",R.drawable.ic_details_cloud_cover_svg,fchEntity.getC() + " %"));

    }
}
