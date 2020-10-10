package com.example.weatherapp.ui.loadingdata;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;
import android.widget.Toast;

import com.example.weatherapp.R;
import com.example.weatherapp.app.DataProccessor;
import com.example.weatherapp.data.model.WeatherDb;
import com.example.weatherapp.ui.base.BaseActivity;
import com.example.weatherapp.ui.dialog.LoadingDialog;
import com.example.weatherapp.ui.home.HomeActivity;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import java.util.List;

import javax.inject.Inject;


public class LoadingDataActivity extends BaseActivity implements LoadingContract.View {

    private FusedLocationProviderClient mFusedLocationClient;

    private Double latLocation;
    private Double lonLocation;

    private LoadingDialog loadingDialog;

    @Inject
    public LoadingContract.Controller loadingController;


    public static LoadingDataActivity newInstance() {
        return new LoadingDataActivity();
    }

    @Override
    protected int layoutRes() {
        return R.layout.activity_loading_data;
    }


    @SuppressLint("VisibleForTests")
    @Override
    protected void dataCreate() {

        loadingDialog = new LoadingDialog(this);

        mFusedLocationClient = new FusedLocationProviderClient(this);

        loadingController.attachView(this);

        if (DataProccessor.getFirstTimeLaunch()) {
            requestPermission();
        } else {
            loadingController.getAllWeather(latLocation, lonLocation);
        }


    }

    @Override
    protected void initView() {

    }


    public void requestPermission() {
        Dexter.withActivity(this).withPermissions(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
        ).withListener(new MultiplePermissionsListener() {

            @Override
            public void onPermissionsChecked(MultiplePermissionsReport report) {
                showLocation();

                new Handler().postDelayed(() -> {
                    loadingController.getAllWeather(latLocation, lonLocation);
                }, 1000);


            }

            @Override
            public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                token.continuePermissionRequest();
            }
        }).withErrorListener(error -> {
            Toast.makeText(this     , "Error occurred! $error",
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


    @Override
    public void showLoadingDB() {

        loadingDialog.startLoading(0);

    }

    @Override
    public void hideLoading() {
        loadingDialog.dismissDialog();
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        DataProccessor.setFirstTimeLaunch(false);
        finish();

    }

    @Override
    public void showLoadingAPI() {
        loadingDialog.startLoading(1);
    }


    @Override
    public void loadDataSuccess(List<WeatherDb> weatherDbList) {

    }

    @Override
    public void loadDataFailed(String message) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        loadingController.detachView(this);
        loadingController.destroy();
    }
}