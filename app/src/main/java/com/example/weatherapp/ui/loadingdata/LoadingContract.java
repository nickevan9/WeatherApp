package com.example.weatherapp.ui.loadingdata;

import com.example.weatherapp.data.model.WeatherDb;
import com.example.weatherapp.ui.base.IBaseController;
import com.example.weatherapp.ui.base.IBaseView;

import java.util.List;

public interface LoadingContract {
    public interface View extends IBaseView{
        void loadDataSuccess(List<WeatherDb> weatherDbList);
        void loadDataFailed(String message);
        void loadDataEmpty();
    }

    public interface Controller extends IBaseController<View>{
        void getAllWeather();

        void getSingleWeather(Double lat,Double lon);
    }
}
