package com.example.weatherapp.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherapp.R;
import com.example.weatherapp.data.WeatherDb;
import com.example.weatherapp.widget.customwidget.WidgetNextDay;
import com.example.weatherapp.widget.customwidget.WidgetNextHour;
import com.example.weatherapp.widget.customwidget.WidgetSunMoon;
import com.example.weatherapp.widget.customwidget.WidgetSunView;
import com.example.weatherapp.widget.customwidget.WidgetToolbar;
import com.example.weatherapp.widget.customwidget.WidgetWeatherStatus;
import com.example.weatherapp.widget.customwidget.WidgetWind;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    private List<WeatherDb> weatherDbs;
    private LayoutInflater mInflater;
    private Context context;

    public HomeAdapter(Context context, List<WeatherDb> weatherDbs) {
        this.weatherDbs = weatherDbs;
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
        WeatherDb weatherDb = weatherDbs.get(position);
        holder.applyData(weatherDb);
    }

    public void applyData(List<WeatherDb> weatherDbList){
        weatherDbs = weatherDbList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return weatherDbs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        WidgetToolbar wgToolbar;
        WidgetWeatherStatus wgWeatherStatus;
        WidgetNextHour wgNextHour;
        WidgetNextDay wgNextDay;
        WidgetWind wgWind;
        WidgetSunView wgSun;



        ViewHolder(View itemView){
            super(itemView);
            wgToolbar = itemView.findViewById(R.id.wg_toolbar);
            wgWeatherStatus = itemView.findViewById(R.id.wg_weather_status);
            wgNextHour = itemView.findViewById(R.id.wg_next_hour);
            wgNextDay = itemView.findViewById(R.id.wg_next_day);
            wgWind = itemView.findViewById(R.id.wg_wind);
            wgSun = itemView.findViewById(R.id.wg_sun);
        }

        public void applyData(WeatherDb weatherDb){
            String timeZone = weatherDb.getWeatherEntity().getLoc().getTzname();
            wgToolbar.applyData(weatherDb.getCityName());
            wgWeatherStatus.applyData(weatherDb.getWeatherEntity().getFch().get(0), weatherDb.getWeatherEntity().getFcd().get(0),timeZone);
            wgNextHour.applyData(weatherDb.getWeatherEntity().getFch(),timeZone);
            wgNextDay.applyData(weatherDb.getWeatherEntity().getFcd(),timeZone);
            wgWind.applyData(weatherDb.getWeatherEntity().getFch().get(0));
            wgSun.applyData(weatherDb.getWeatherEntity().getFcd().get(0),timeZone);
//            if (wgSun.isHadRunAnimation()){
//                wgSun.runProgress(0);
//            }

        }

    }
}
