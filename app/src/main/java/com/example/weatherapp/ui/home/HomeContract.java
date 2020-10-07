package com.example.weatherapp.ui.home;

import com.example.weatherapp.data.WeatherDb;
import com.example.weatherapp.ui.base.IBaseController;
import com.example.weatherapp.ui.base.IBaseView;

import java.util.List;

public interface HomeContract {
    public interface View extends IBaseView {
        void showLoading();
        void hideLoading();
        void loadDataSuccess(List<WeatherDb> weatherDbList);
        void loadDataFailed(String message);
    }

    public interface Controller extends IBaseController<HomeContract.View> {
        void getAllWeather();
    }
}
