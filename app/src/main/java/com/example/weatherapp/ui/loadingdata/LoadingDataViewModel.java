package com.example.weatherapp.ui.loadingdata;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.weatherapp.data.model.WeatherEntity;
import com.example.weatherapp.data.repository.WeatherRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class LoadingDataViewModel extends ViewModel {
    private final WeatherRepository repoRepository;
    private CompositeDisposable disposable;

    private final MutableLiveData<WeatherEntity> weather = new MutableLiveData<>();
    private final MutableLiveData<Boolean> repoLoadError = new MutableLiveData<>();
    private final MutableLiveData<Boolean> loading = new MutableLiveData<>();

    @Inject
    public LoadingDataViewModel(WeatherRepository repoRepository) {
        this.repoRepository = repoRepository;
        disposable = new CompositeDisposable();
    }

    LiveData<WeatherEntity> getWeather() {
        return weather;
    }

    LiveData<Boolean> getError() {
        return repoLoadError;
    }

    LiveData<Boolean> getLoading() {
        return loading;
    }


    private void fetchAllWeather(double lat, double lon) {
        loading.setValue(true);
        disposable.add(repoRepository.getWeatherData(lat, lon)
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<WeatherEntity>() {
            @Override
            public void onSuccess(WeatherEntity weatherEntity) {

            }

            @Override
            public void onError(Throwable e) {

            }
        }));
    }
}