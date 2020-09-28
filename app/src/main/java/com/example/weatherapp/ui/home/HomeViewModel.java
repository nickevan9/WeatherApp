package com.example.weatherapp.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.weatherapp.data.WeatherDb;
import com.example.weatherapp.data.repository.WeatherRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class HomeViewModel extends ViewModel {

    private final WeatherRepository repoRepository;
    private CompositeDisposable disposable;

    private final MutableLiveData<Boolean> loadingDb = new MutableLiveData<>();
    private final MutableLiveData<List<WeatherDb>> weatherList = new MutableLiveData<>();
    private final MutableLiveData<Boolean> loadError = new MutableLiveData<>();

    @Inject
    public HomeViewModel(WeatherRepository repoRepository) {
        this.repoRepository = repoRepository;
        disposable = new CompositeDisposable();
    }

    LiveData<List<WeatherDb>> getListWeather() {
        return weatherList;
    }


    public void getAllWeather() {
        loadingDb.setValue(true);
        disposable.add(repoRepository.getAllWeatherFromDb().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableSingleObserver<List<WeatherDb>>() {

            @Override
            public void onSuccess(List<WeatherDb> weatherDbs) {
                weatherList.setValue(weatherDbs);
                loadError.setValue(false);
                loadingDb.setValue(false);
            }

            @Override
            public void onError(Throwable e) {
                loadError.setValue(true);
                loadingDb.setValue(false);
            }
        }));
    }


    @Override
    protected void onCleared() {
        super.onCleared();
        if (disposable != null) {
            disposable.clear();
            disposable = null;
        }
    }
}