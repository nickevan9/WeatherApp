package com.example.weatherapp.ui.location;

import com.example.weatherapp.ui.base.IBaseController;
import com.example.weatherapp.ui.base.IBaseView;

public interface LocationContract {
    public interface View extends IBaseView {

        void insertDataSuccess();
        void loadDataFailed(String message);
    }

    public interface Controller extends IBaseController<LocationContract.View> {
        void getSingleWeather(Double lat,Double lon);
    }
}
