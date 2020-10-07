package com.example.weatherapp.ui.loadingdata;

import com.example.weatherapp.data.WeatherDb;
import com.example.weatherapp.ui.base.IBaseController;
import com.example.weatherapp.ui.base.IBaseView;

import java.util.List;

public interface LoadingContract {
    public interface View extends IBaseView{
        void showLoading();
        void hideLoading();
        void loadDataSuccess(List<WeatherDb> weatherDbList);
        void loadDataFailed(String message);
    }

    public interface Controller extends IBaseController<View>{
        void getAllWeather(Double lat,Double lon);
    }
}
