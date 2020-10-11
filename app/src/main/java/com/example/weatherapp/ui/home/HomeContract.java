package com.example.weatherapp.ui.home;

import com.example.weatherapp.data.model.WeatherDb;
import com.example.weatherapp.ui.base.IBaseController;
import com.example.weatherapp.ui.base.IBaseView;

import java.util.List;

public interface HomeContract {
    public interface View extends IBaseView {
        void loadDataSuccess(List<WeatherDb> weatherDbList,Boolean addWeather);
        void loadDataFailed(String message);
    }

    public interface Controller extends IBaseController<HomeContract.View> {
        void getAllWeather(Boolean addWeather);
        void getSingleWeather(Double lat,Double lon);
    }
}
