package com.example.weatherapp.ui.loadingdata;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.weatherapp.data.WeatherDb;
import com.example.weatherapp.data.model.WeatherEntity;
import com.example.weatherapp.data.repository.WeatherRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class LoadingDataViewModel extends ViewModel {
    private final WeatherRepository repoRepository;
    private CompositeDisposable disposable;

    private final MutableLiveData<WeatherEntity> weather = new MutableLiveData<>();
    private final MutableLiveData<List<WeatherDb>> weatherList = new MutableLiveData<>();
    private final MutableLiveData<Boolean> loadError = new MutableLiveData<>();
    private final MutableLiveData<Boolean> loadingDb = new MutableLiveData<>();
    private final MutableLiveData<Boolean> loadingApi = new MutableLiveData<>();
    private final MutableLiveData<Boolean> loadingAllData = new MutableLiveData<>();

    @Inject
    public LoadingDataViewModel(WeatherRepository repoRepository) {
        this.repoRepository = repoRepository;
        disposable = new CompositeDisposable();
    }

    LiveData<WeatherEntity> getWeather() {
        return weather;
    }

    LiveData<Boolean> getError() {
        return loadError;
    }

    LiveData<Boolean> getLoadingApi() {
        return loadingApi;
    }

    LiveData<Boolean> getLoadingDb() {
        return loadingDb;
    }

    LiveData<List<WeatherDb>> getListWeather() {
        return weatherList;
    }

    LiveData<Boolean> getLoadingAllData(){
        return loadingAllData;
    }


    public void fetchSingleWeather(double lat, double lon) {
        loadingApi.setValue(true);
        disposable.add(repoRepository.getWeatherData(lat, lon)
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<WeatherEntity>() {
                    @Override
                    public void onSuccess(WeatherEntity weatherEntity) {
                        loadError.setValue(false);
                        weather.setValue(weatherEntity);
                        loadingApi.setValue(false);
                    }

                    @Override
                    public void onError(Throwable e) {
                        loadError.setValue(true);
                        loadingApi.setValue(false);
                    }
                }));
    }

    public void fetchAllWeather(List<WeatherDb> weatherDbList){
        for (WeatherDb weatherDb : weatherDbList){
            Double lat = weatherDb.getLatLocation();
            Double lon = weatherDb.getLonLocation();

            disposable.add(repoRepository.getWeatherData(lat, lon)
                    .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(new DisposableSingleObserver<WeatherEntity>() {
                        @Override
                        public void onSuccess(WeatherEntity weatherEntity) {
                            loadError.setValue(false);
                            loadingApi.setValue(false);
                        }

                        @Override
                        public void onError(Throwable e) {
                            loadError.setValue(true);
                            loadingApi.setValue(false);
                        }
                    }));
        }
    }

    public void insertToDb(WeatherDb weatherDb) {
        disposable.add(repoRepository.addWeather(weatherDb)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<Integer>() {

                    @Override
                    public void onSuccess(Integer integer) {
                        loadError.setValue(false);
                    }

                    @Override
                    public void onError(Throwable e) {
                        loadError.setValue(true);
                        loadingDb.setValue(false);
                    }
                }));
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