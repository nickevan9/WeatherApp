package com.example.weatherapp.ui.place;

import com.example.weatherapp.data.model.WeatherDb;
import com.example.weatherapp.ui.base.IBaseController;
import com.example.weatherapp.ui.base.IBaseView;

import java.util.List;

public interface PlaceContract {
    public interface View extends IBaseView {
        void loadDataSuccess(String message);
        void loadDataFailed(String message);
    }

    public interface Controller extends IBaseController<View> {
        void getSingleWeather(Double lat,Double lon);
    }
}
