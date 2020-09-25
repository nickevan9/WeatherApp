package com.example.weatherapp.ui.home;

import androidx.lifecycle.ViewModel;

import com.example.weatherapp.data.response.WeatherRepository;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class HomeViewModel extends ViewModel {

    private final WeatherRepository repoRepository;
    private CompositeDisposable disposable;
    @Inject
    public HomeViewModel(WeatherRepository repoRepository) {
        this.repoRepository = repoRepository;
        disposable = new CompositeDisposable();
//        fetchRepos();
    }
}