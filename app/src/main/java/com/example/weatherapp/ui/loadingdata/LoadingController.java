package com.example.weatherapp.ui.loadingdata;

import com.example.weatherapp.data.model.WeatherAir;
import com.example.weatherapp.data.model.WeatherDb;
import com.example.weatherapp.data.model.air.AirEntity;
import com.example.weatherapp.data.model.weather.WeatherEntity;
import com.example.weatherapp.data.repository.WeatherRepository;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class LoadingController implements LoadingContract.Controller {
    private final WeatherRepository repoRepository;
    private CompositeDisposable disposable = new CompositeDisposable();
    private LoadingContract.View mView;


    public LoadingController(WeatherRepository repoRepository) {
        this.repoRepository = repoRepository;
    }

    @Override
    public void getAllWeather(Double lat, Double lon) {
        mView.showLoadingDB();

        disposable.add(repoRepository.getAllWeatherFromDb().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableSingleObserver<List<WeatherDb>>() {

            @Override
            public void onSuccess(List<WeatherDb> weatherDbs) {
                if (weatherDbs.isEmpty()) {
                    fetchSingleWeather(lat, lon);
                } else {
                    fetchAllWeather(weatherDbs);
                }
            }

            @Override
            public void onError(Throwable e) {
                mView.loadDataFailed(e.getMessage());
            }
        }));
    }


    public void fetchSingleWeather(double lat, double lon) {

        Single<WeatherAir> combined = Single.zip(getWeatherEntity(lat, lon), getAirEntity(lat, lon), WeatherAir::new);

        combined.subscribe(new SingleObserver<WeatherAir>() {
            @Override
            public void onSubscribe(Disposable d) {
                disposable.add(d);
            }

            @Override
            public void onSuccess(WeatherAir weatherAir) {
                WeatherDb weatherDb = createWeather(weatherAir);
                insertToDb(weatherDb, true);
            }

            @Override
            public void onError(Throwable e) {
                mView.loadDataFailed(e.getMessage());
            }
        });


    }

    public void fetchAllWeather(List<WeatherDb> weatherDbList) {

        for (int index = 0 ; index < weatherDbList.size(); index++) {
            Double lat = weatherDbList.get(index).getLatLocation();
            Double lon = weatherDbList.get(index).getLonLocation();

            Single<WeatherAir> combined = Single.zip(getWeatherEntity(lat, lon), getAirEntity(lat, lon), WeatherAir::new);

            int finalIndex = index;
            combined.subscribe(new SingleObserver<WeatherAir>() {
                @Override
                public void onSubscribe(Disposable d) {
                    disposable.add(d);
                }

                @Override
                public void onSuccess(WeatherAir weatherAir) {
                    WeatherDb weatherDb = createWeather(weatherAir);
                    if (finalIndex == (weatherDbList.size() - 1)) {
                        insertToDb(weatherDb, true);
                    } else {
                        insertToDb(weatherDb, false);
                    }
                }

                @Override
                public void onError(Throwable e) {
                    mView.loadDataFailed(e.getMessage());
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

    public void insertToDb(WeatherDb weatherDb, Boolean lastPosition) {

        disposable.add(repoRepository.addWeather(weatherDb)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<Long>() {

                    @Override
                    public void onSuccess(Long aLong) {
                        if (lastPosition) {
                            mView.hideLoadingDB();
                        }
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
    public void attachView(LoadingContract.View view) {
        this.mView = view;
    }

    @Override
    public void detachView(LoadingContract.View view) {
        this.mView = view;
    }

    @Override
    public void destroy() {
        disposable.clear();
    }
}
