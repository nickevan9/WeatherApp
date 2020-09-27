package com.example.weatherapp.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherapp.R;
import com.example.weatherapp.data.model.WeatherEntity;
import com.example.weatherapp.widget.customwidget.WidgetNextDay;
import com.example.weatherapp.widget.customwidget.WidgetNextHour;
import com.example.weatherapp.widget.customwidget.WidgetSunView;
import com.example.weatherapp.widget.customwidget.WidgetWeatherStatus;
import com.example.weatherapp.widget.customwidget.WidgetWind;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    private List<WeatherEntity> weatherEntityList;
    private LayoutInflater mInflater;
    private String timeZone;
    private Context context;

    public HomeAdapter(Context context, List<WeatherEntity> weatherEntityList, String timeZone) {
        this.weatherEntityList = weatherEntityList;
        this.timeZone = timeZone;
        this.context = context;
        this.mInflater = LayoutInflater.from(context);

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_weather, parent, false);
        return new HomeAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        WeatherEntity weatherEntity = weatherEntityList.get(position);
        holder.applyData(weatherEntity);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        WidgetWeatherStatus wgWeatherStatus;
        WidgetNextHour wgNextHour;
        WidgetNextDay wgNextDay;
        WidgetWind wgWind;
        WidgetSunView wgSun;


        ViewHolder(View itemView){
            super(itemView);
            wgWeatherStatus = itemView.findViewById(R.id.wg_weather_status);
            wgNextHour = itemView.findViewById(R.id.wg_next_hour);
            wgNextDay = itemView.findViewById(R.id.wg_next_day);
            wgWind = itemView.findViewById(R.id.wg_wind);
            wgSun = itemView.findViewById(R.id.wg_sun);
        }

        public void applyData(WeatherEntity weatherEntity){
            String timeZone = weatherEntity.getLoc().getTzname();
            wgWeatherStatus.applyData(weatherEntity.getFch().get(0), weatherEntity.getFcd().get(0),timeZone);
            wgNextHour.applyData(weatherEntity.getFch(),timeZone);
            wgNextDay.applyData(weatherEntity.getFcd(),timeZone);
            wgWind.applyData(weatherEntity.getFch().get(0));
            wgSun.applyData(weatherEntity.getFcd().get(0),timeZone);
        }

    }
}
