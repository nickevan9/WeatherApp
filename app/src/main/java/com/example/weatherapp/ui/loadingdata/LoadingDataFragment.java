package com.example.weatherapp.ui.loadingdata;

import android.Manifest;
import android.annotation.SuppressLint;
import android.os.Handler;
import android.widget.Toast;

import androidx.lifecycle.ViewModelProvider;

import com.example.weatherapp.R;
import com.example.weatherapp.app.DataProccessor;
import com.example.weatherapp.app.FragmentUtils;
import com.example.weatherapp.data.WeatherAir;
import com.example.weatherapp.data.WeatherDb;
import com.example.weatherapp.data.model.weather.WeatherEntity;
import com.example.weatherapp.factory.ViewModelFactory;
import com.example.weatherapp.ui.base.BaseFragment;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import java.util.List;

import javax.inject.Inject;


public class LoadingDataFragment extends BaseFragment {

    private LoadingDataViewModel mViewModel;

    private FusedLocationProviderClient mFusedLocationClient;

    private Double latLocation;
    private Double lonLocation;


    @Inject
    ViewModelFactory viewModelFactory;

    public static LoadingDataFragment newInstance() {
        return new LoadingDataFragment();
    }

    @Override
    protected int layoutRes() {
        return R.layout.fragment_loading_data;
    }

    @SuppressLint("VisibleForTests")
    @Override
    protected void dataCreate() {

        mFusedLocationClient = new FusedLocationProviderClient(requireContext());
        mViewModel = new ViewModelProvider(this, viewModelFactory).get(LoadingDataViewModel.class);

        if (DataProccessor.getFirstTimeLaunch()) {
            requestPermission();
        } else {
            mViewModel.getAllWeather();
        }

        mViewModel.getWeatherAirData().observe(getViewLifecycleOwner(), weatherAir -> {
            mViewModel.insertToDb(createWeather(weatherAir));
        });

        mViewModel.getInsertDb().observe(getViewLifecycleOwner(), aBoolean -> {
            if (aBoolean) {
                DataProccessor.setFirstTimeLaunch(false);
                requireActivity().runOnUiThread(() -> FragmentUtils.findNavController(requireParentFragment()).navigate(R.id.action_loadingDataFragment_to_homeFragment));

            }
        });

        mViewModel.getError().observe(getViewLifecycleOwner(), aBoolean -> {

        });

        mViewModel.getLoadingApi().observe(getViewLifecycleOwner(), aBoolean -> {

        });

        mViewModel.getLoadingDb().observe(getViewLifecycleOwner(), aBoolean -> {

        });

        mViewModel.getListWeather().observe(getViewLifecycleOwner(), weatherDbList -> {
            if (weatherDbList.isEmpty()) {
                mViewModel.fetchSingleWeather(latLocation, lonLocation);
            } else {
                mViewModel.fetchAllWeather(weatherDbList);
            }
        });

        mViewModel.getLoadingAllData().observe(getViewLifecycleOwner(), aBoolean -> {
            if (!aBoolean) {
                requireActivity().runOnUiThread(() -> FragmentUtils.findNavController(requireParentFragment()).navigate(R.id.action_loadingDataFragment_to_homeFragment));
            }
        });
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void fragmentBackPressed() {

    }

    public void requestPermission() {
        Dexter.withActivity(requireActivity()).withPermissions(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
        ).withListener(new MultiplePermissionsListener() {

            @Override
            public void onPermissionsChecked(MultiplePermissionsReport report) {
                showLocation();

                new Handler().postDelayed(() -> {
                    mViewModel.getAllWeather();
                }, 1000);


            }

            @Override
            public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                token.continuePermissionRequest();
            }
        }).withErrorListener(error -> {
            Toast.makeText(requireContext(), "Error occurred! $error",
                    Toast.LENGTH_SHORT);

        }).onSameThread().check();
    }

    @SuppressLint("MissingPermission")
    private void showLocation() {
        mFusedLocationClient.getLastLocation().addOnSuccessListener(location -> {
            this.latLocation = location.getLatitude();
            this.lonLocation = location.getLongitude();
        });
    }

    private WeatherDb createWeather(WeatherAir weatherAir) {
        WeatherDb weatherDb = new WeatherDb();
        weatherDb.setCityName(weatherAir.weatherEntity.getLoc().getAdm1());
        weatherDb.setLatLocation(weatherAir.weatherEntity.getLoc().getLat());
        weatherDb.setLonLocation(weatherAir.weatherEntity.getLoc().getLon());
        weatherDb.setWeatherEntity(weatherAir.weatherEntity);
        weatherDb.setAirEntity(weatherAir.airEntity);
        return weatherDb;

    }

}