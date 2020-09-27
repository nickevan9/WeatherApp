package com.example.weatherapp.di.modules;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.weatherapp.factory.ViewModelFactory;
import com.example.weatherapp.ui.detail.daydetail.DayDetailViewModel;
import com.example.weatherapp.ui.detail.hourdetail.HourDetailFragment;
import com.example.weatherapp.ui.detail.hourdetail.HourDetailViewModel;
import com.example.weatherapp.ui.home.HomeViewModel;
import com.example.weatherapp.ui.loadingdata.LoadingDataViewModel;
import com.example.weatherapp.ui.location.LocationViewModel;
import com.example.weatherapp.ui.setting.SettingViewModel;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

//@Singleton
@Module
public abstract  class ViewModelModule {


    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel.class)
    abstract ViewModel bindListViewModel(HomeViewModel homeViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(LoadingDataViewModel.class)
    abstract ViewModel bindLoadingDataViewModel(LoadingDataViewModel loadingDataViewModel);

//    @Binds
//    @IntoMap
//    @ViewModelKey(LocationViewModel.class)
//    abstract ViewModel bindLocationViewModel(LocationViewModel locationViewModel);
//
//    @Binds
//    @IntoMap
//    @ViewModelKey(SettingViewModel.class)
//    abstract ViewModel bindSettingViewModel(SettingViewModel settingViewModel);
//
//    @Binds
//    @IntoMap
//    @ViewModelKey(DayDetailViewModel.class)
//    abstract ViewModel bindDayDetailViewModel(DayDetailViewModel dayDetailViewModel);
//
//    @Binds
//    @IntoMap
//    @ViewModelKey(HourDetailViewModel.class)
//    abstract ViewModel bindHourDetailViewModel(HourDetailViewModel hourDetailViewModel);
}
