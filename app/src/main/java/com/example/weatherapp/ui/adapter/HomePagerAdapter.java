package com.example.weatherapp.ui.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.weatherapp.app.TimeUtilsExt;
import com.example.weatherapp.data.model.WeatherDb;
import com.example.weatherapp.data.model.weather.FcdEntity;
import com.example.weatherapp.data.model.weather.FchEntity;
import com.example.weatherapp.widget.customwidget.WeatherStatusFragment;

import java.util.List;

public class HomePagerAdapter extends FragmentStateAdapter {
    private List<WeatherDb> weatherDbs;

    public HomePagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle, List<WeatherDb> weatherDbList) {
        super(fragmentManager, lifecycle);
        this.weatherDbs = weatherDbList;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        WeatherDb weatherDb = weatherDbs.get(position);

        String timeZone = weatherDb.getWeatherEntity().getLoc().getTzname();

        List<FchEntity> fchEntityList = TimeUtilsExt.mapTimeToNow(weatherDb.getWeatherEntity().getFch(), timeZone);
        List<FcdEntity> fcdEntityList = TimeUtilsExt.mapDateToNow(weatherDb.getWeatherEntity().getFcd(), timeZone);

        return WeatherStatusFragment.newInstance(fchEntityList.get(0), fcdEntityList.get(0), timeZone);
    }

    @Override
    public int getItemCount() {
        return weatherDbs.size();
    }

    public void applyData(List<WeatherDb> dbList){
        this.weatherDbs = dbList;
        notifyDataSetChanged();
    }
}
