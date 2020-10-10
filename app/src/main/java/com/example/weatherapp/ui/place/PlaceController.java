package com.example.weatherapp.ui.place;

import com.example.weatherapp.data.model.WeatherAir;
import com.example.weatherapp.data.model.WeatherDb;
import com.example.weatherapp.data.model.air.AirEntity;
import com.example.weatherapp.data.model.weather.WeatherEntity;
import com.example.weatherapp.data.repository.WeatherRepository;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class PlaceController implements PlaceContract.Controller {
    private final WeatherRepository repoRepository;
    private CompositeDisposable disposable = new CompositeDisposable();
    private PlaceContract.View mView;

    public PlaceController(WeatherRepository repoRepository) {
        this.repoRepository = repoRepository;
    }

    @Override
    public void getSingleWeather(Double lat, Double lon) {
        mView.showLoadingAPI();

        Single<WeatherAir> combined = Single.zip(getWeatherEntity(lat, lon), getAirEntity(lat, lon), WeatherAir::new);

        combined.subscribe(new SingleObserver<WeatherAir>() {
            @Override
            public void onSubscribe(Disposable d) {
                disposable.add(d);
            }

            @Override
            public void onSuccess(WeatherAir weatherAir) {
                WeatherDb weatherDb = createWeather(weatherAir);
                insertToDb(weatherDb);
            }

            @Override
            public void onError(Throwable e) {
                mView.loadDataFailed(e.getMessage());
            }
        });
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

        disposable.add(repoRepository.addWeather(weatherDb)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<Long>() {

                    @Override
                    public void onSuccess(Long aLong) {
                        mView.hideLoadingAPI();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.loadDataFailed(e.getMessage());
                    }
                }));
    }

    private WeatherDb createWeather(WeatherAir weatherAir) {
        WeatherDb weatherDb = new WeatherDb();
        weatherDb.setLocationName(weatherAir.weatherEntity.getLoc().getName());
        weatherDb.setCityName(weatherAir.weatherEntity.getLoc().getAdm1());
        weatherDb.setLatLocation(weatherAir.weatherEntity.getLoc().getLat());
        weatherDb.setLonLocation(weatherAir.weatherEntity.getLoc().getLon());
        weatherDb.setWeatherEntity(weatherAir.weatherEntity);
        weatherDb.setAirEntity(weatherAir.airEntity);
        return weatherDb;

    }

    @Override
    public void attachView(PlaceContract.View view) {
        this.mView = view;

    }

    @Override
    public void detachView(PlaceContract.View view) {
        this.mView = null;
    }

    @Override
    public void destroy() {
        disposable.clear();
    }
}