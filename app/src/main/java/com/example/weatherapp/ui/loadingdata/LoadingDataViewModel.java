package com.example.weatherapp.ui.loadingdata;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.weatherapp.data.WeatherAir;
import com.example.weatherapp.data.WeatherDb;
import com.example.weatherapp.data.model.air.AirEntity;
import com.example.weatherapp.data.model.weather.WeatherEntity;
import com.example.weatherapp.data.repository.WeatherRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class LoadingDataViewModel extends ViewModel {
    private final WeatherRepository repoRepository;
    private CompositeDisposable disposable;

    private final MutableLiveData<WeatherAir> weatherAirData = new MutableLiveData<>();
    private final MutableLiveData<List<WeatherDb>> weatherList = new MutableLiveData<>();
    private final MutableLiveData<Boolean> loadError = new MutableLiveData<>();
    private final MutableLiveData<Boolean> loadingDb = new MutableLiveData<>();
    private final MutableLiveData<Boolean> loadingApi = new MutableLiveData<>();
    private final MutableLiveData<Boolean> loadingAllData = new MutableLiveData<>();
    private final MutableLiveData<Boolean> insertDB = new MutableLiveData<>();


    @Inject
    public LoadingDataViewModel(WeatherRepository repoRepository) {
        this.repoRepository = repoRepository;
        disposable = new CompositeDisposable();
    }

    LiveData<WeatherAir> getWeatherAirData() {
        return weatherAirData;
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

    LiveData<Boolean> getLoadingAllData() {
        return loadingAllData;
    }

    LiveData<Boolean> getInsertDb() {
        return insertDB;
    }


    public void fetchSingleWeather(double lat, double lon) {
        loadingApi.setValue(true);

        Single<WeatherAir> combined = Single.zip(getWeatherEntity(lat, lon), getAirEntity(lat, lon), WeatherAir::new);

        combined.subscribe(new SingleObserver<WeatherAir>() {
            @Override
            public void onSubscribe(Disposable d) {
                disposable.add(d);
            }

            @Override
            public void onSuccess(WeatherAir weatherAir) {
                loadError.setValue(false);
                weatherAirData.setValue(weatherAir);
                loadingApi.setValue(false);
            }

            @Override
            public void onError(Throwable e) {
                loadError.setValue(true);
                loadingApi.setValue(false);
            }
        });


    }


    public void fetchAllWeather(List<WeatherDb> weatherDbList) {
        loadingAllData.setValue(true);
        for (WeatherDb weatherDb : weatherDbList) {
            Double lat = weatherDb.getLatLocation();
            Double lon = weatherDb.getLonLocation();

            Single<WeatherAir> combined = Single.zip(getWeatherEntity(lat, lon), getAirEntity(lat, lon), WeatherAir::new);

            combined.subscribe(new SingleObserver<WeatherAir>() {
                @Override
                public void onSubscribe(Disposable d) {
                    disposable.add(d);
                }

                @Override
                public void onSuccess(WeatherAir weatherAir) {
                    loadError.setValue(false);
                    if (weatherDbList.indexOf(weatherDb) == (weatherDbList.size() - 1)) {
                        loadingAllData.setValue(false);
                    }
                }

                @Override
                public void onError(Throwable e) {
                    loadError.setValue(true);
                    loadingAllData.setValue(false);
                }
            });

        }
    }

    private Single<WeatherEntity> getWeatherEntity(Double lat, Double lon) {
        return repoRepository.getWeatherData(lat, lon).
                subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    private Single<AirEntity> getAirEntity(Double lat, Double lon) {
        return repoRepository.getAirData(lat, lon).
                subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public void insertToDb(WeatherDb weatherDb) {
        insertDB.setValue(false);
        disposable.add(repoRepository.addWeather(weatherDb)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<Long>() {

                    @Override
                    public void onSuccess(Long aLong) {
                        loadError.setValue(false);
                        insertDB.setValue(true);
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