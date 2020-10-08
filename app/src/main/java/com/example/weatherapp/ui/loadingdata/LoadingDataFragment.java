package com.example.weatherapp.ui.loadingdata;

import android.Manifest;
import android.annotation.SuppressLint;
import android.os.Handler;
import android.widget.Toast;
import com.example.weatherapp.R;
import com.example.weatherapp.app.DataProccessor;
import com.example.weatherapp.app.FragmentUtils;
import com.example.weatherapp.data.WeatherDb;
import com.example.weatherapp.ui.base.BaseFragment;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import java.util.List;
import javax.inject.Inject;


public class LoadingDataFragment extends BaseFragment implements LoadingContract.View {

    private FusedLocationProviderClient mFusedLocationClient;

    private Double latLocation;
    private Double lonLocation;

    @Inject
    public LoadingContract.Controller loadingController;


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
                    loadingController.getAllWeather(latLocation, lonLocation);
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


    @Override
    public void showLoadingDB() {

    }

    @Override
    public void hideLoadingDB() {
        FragmentUtils.findNavController(requireParentFragment()).navigate(R.id.action_loadingDataFragment_to_homeFragment);
        DataProccessor.setFirstTimeLaunch(false);
    }

    @Override
    public void showLoadingAPI() {

    }

    @Override
    public void hideLoadingAPI() {

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