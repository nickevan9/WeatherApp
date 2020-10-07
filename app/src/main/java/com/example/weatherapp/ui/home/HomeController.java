package com.example.weatherapp.ui.home;

import com.example.weatherapp.data.WeatherDb;
import com.example.weatherapp.data.repository.WeatherRepository;
import com.example.weatherapp.ui.loadingdata.LoadingContract;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class HomeController implements HomeContract.Controller {
    private final WeatherRepository repoRepository;
    private CompositeDisposable disposable = new CompositeDisposable();
    private HomeContract.View mView;

    public HomeController(WeatherRepository repoRepository) {
        this.repoRepository = repoRepository;
    }

    @Override
    public void getAllWeather() {
        mView.showLoading();
        disposable.add(repoRepository.getAllWeatherFromDb().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableSingleObserver<List<WeatherDb>>() {

            @Override
            public void onSuccess(List<WeatherDb> weatherDbs) {
                mView.loadDataSuccess(weatherDbs);
                mView.hideLoading();
            }

            @Override
            public void onError(Throwable e) {
                mView.loadDataFailed(e.getMessage());
            }
        }));
    }

    @Override
    public void attachView(HomeContract.View view) {
        this.mView = view;
        getAllWeather();
    }

    @Override
    public void detachView(HomeContract.View view) {
        this.mView = view;
    }

    @Override
    public void destroy() {
        disposable.clear();
    }
}
